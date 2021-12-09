package pers.cgglyle.service.acconut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.base.model.BaseQuery;
import pers.cgglyle.base.service.impl.BaseServiceImpl;
import pers.cgglyle.response.ApiException;
import pers.cgglyle.response.PageResult;
import pers.cgglyle.service.acconut.mapper.UserMapper;
import pers.cgglyle.service.acconut.model.dto.UserAddDto;
import pers.cgglyle.service.acconut.model.dto.UserRoleRelationDto;
import pers.cgglyle.service.acconut.model.dto.UserUpdateDto;
import pers.cgglyle.service.acconut.model.entity.UserEntity;
import pers.cgglyle.service.acconut.model.entity.UserRoleRelationEntity;
import pers.cgglyle.service.acconut.model.query.UserQuery;
import pers.cgglyle.service.acconut.model.vo.UserRoleVo;
import pers.cgglyle.service.acconut.model.vo.UserVo;
import pers.cgglyle.service.acconut.service.UserRoleRelationService;
import pers.cgglyle.service.acconut.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户服务层实现类
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserEntity> implements UserService {

    private final UserRoleRelationService roleRelationService;

    public UserServiceImpl(UserRoleRelationService roleRelationService) {
        this.roleRelationService = roleRelationService;
    }

    @Override
    public PageResult getPage(BaseQuery baseQuery) {
        UserQuery userQuery = (UserQuery) baseQuery;
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        if (userQuery.getUserName() != null) {
            wrapper.like("user_name", userQuery.getUserName());
        }
        if (userQuery.getUserEmail() != null) {
            wrapper.eq("user_email", userQuery.getUserEmail());
        }
        if (userQuery.getGender() != null) {
            wrapper.eq("user_gender", userQuery.getGender());
        }
        if (userQuery.getPhone() != null) {
            wrapper.eq("user_phone", userQuery.getPhone());
        }
        if (userQuery.getUserNickName() != null) {
            wrapper.like("user_nick_name", userQuery.getUserNickName());
        }
        if (userQuery.getUserRole() != null) {
            List<Integer> userIdList = roleRelationService.getUserIdList(userQuery.getUserRole());
            for (Integer id : userIdList) {
                wrapper.or().eq("id", id);
            }
        }
        wrapper.orderByDesc("id");
        // 创建分页
        Page<UserEntity> page = new Page<>(userQuery.getPageNum(), userQuery.getPageSize());
        // 分页查询
        Page<UserEntity> data = baseMapper.selectPage(page, wrapper);
        // 流式处理
        List<UserVo> collect = data.getRecords().stream().map(user -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            List<UserRoleVo> userRoleList = roleRelationService.getUserRoleList(user.getId());
            userVo.setUserRole(userRoleList);
            return userVo;
        }).collect(Collectors.toList());
        return new PageResult(userQuery.getPageNum(), userQuery.getPageSize(), data.getTotal(), data.getPages(), collect);
    }

    @Override
    public boolean addUser(UserAddDto userAddDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userAddDto, userEntity);
        userEntity.setUserPasswordUpdateTime(LocalDateTime.now());
        return this.add(userEntity);
    }

    @Override
    public boolean updateUser(UserUpdateDto userUpdateDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userUpdateDto, userEntity);
        userEntity.setUpdateTime(LocalDateTime.now());
        //判断是否修改密码(修改过执行，没修改过不执行）
        if (!userUpdateDto.getUserPassword().equals(this.getById(userUpdateDto.getId()).getUserPassword())) {
            userEntity.setUserPasswordUpdateTime(LocalDateTime.now());
        }
        return this.update(userEntity);
    }

    @Override
    public boolean addUserRole(UserRoleRelationDto userRoleRelationDto) {
        return roleRelationService.addUserRole(userRoleRelationDto);
    }

    @Override
    public boolean delete(Integer id) {
        UserEntity userEntity = this.getById(id);
        if (userEntity.isSystem()) {
            throw new ApiException("系统用户，无法删除");
        }
        QueryWrapper<UserRoleRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", id);
        boolean remove = roleRelationService.remove(wrapper);
        boolean b = this.removeById(id);
        return remove && b;

    }
}
