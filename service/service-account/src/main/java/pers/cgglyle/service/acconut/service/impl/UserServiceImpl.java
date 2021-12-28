package pers.cgglyle.service.acconut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pers.cgglyle.common.annotaion.RedisCache;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.common.util.redis.RedisUtils;
import pers.cgglyle.service.acconut.mapper.UserMapper;
import pers.cgglyle.service.acconut.model.dto.UserAddDto;
import pers.cgglyle.service.acconut.model.dto.UserRoleRelationDto;
import pers.cgglyle.service.acconut.model.dto.UserUpdateDto;
import pers.cgglyle.service.acconut.model.entity.UserEntity;
import pers.cgglyle.service.acconut.model.entity.UserGroupRelationEntity;
import pers.cgglyle.service.acconut.model.entity.UserRoleRelationEntity;
import pers.cgglyle.service.acconut.model.query.UserQuery;
import pers.cgglyle.service.acconut.model.vo.UserGroupVo;
import pers.cgglyle.service.acconut.model.vo.UserRoleVo;
import pers.cgglyle.service.acconut.model.vo.UserVo;
import pers.cgglyle.service.acconut.service.UserGroupRelationService;
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

    @Autowired
    private RedisUtils redisUtils;
//    @Autowired
//    private AuthenticationManager authenticationManager;

    private final UserRoleRelationService roleRelationService;
    private final UserGroupRelationService userGroupRelationService;

    public UserServiceImpl(UserRoleRelationService roleRelationService,
                           UserGroupRelationService userGroupRelationService) {
        this.roleRelationService = roleRelationService;
        this.userGroupRelationService = userGroupRelationService;
    }

    @RedisCache(timeout = 7200L)
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
        if (userQuery.getUserGroup() != null) {
            List<Integer> userIdList = userGroupRelationService.getUserIdList(userQuery.getUserGroup());
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
            List<UserGroupVo> userGroupList = userGroupRelationService.getUserGroupList(user.getId());
            userVo.setUserGroup(userGroupList);
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

    /**
     * 删除用户
     * <p>
     * 删除用户同时会删除该用户的所有角色。
     * <p>
     * 删除用户同时会删除该用户的所有组
     *
     * @param id 主键id
     * @return true-成功,false-失败
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean delete(Integer id) {
        boolean b = super.delete(id);
        if (!b) {
            throw new ApiException("用户删除失败");
        }
        QueryWrapper<UserRoleRelationEntity> wrapperRole = new QueryWrapper<>();
        wrapperRole.eq("user_id", id);
        boolean removeRole = roleRelationService.remove(wrapperRole);
        if (!removeRole) {
            throw new ApiException("用户角色删除失败");
        }
        QueryWrapper<UserGroupRelationEntity> wrapperGroup = new QueryWrapper<>();
        wrapperGroup.eq("user_id", id);
        boolean removeGroup = userGroupRelationService.remove(wrapperGroup);
        if (!removeGroup) {
            throw new ApiException("用户组删除失败");
        }
        return true;

    }

    /**
     * 批量删除用户
     * <p>
     * 删除用户同时会删除该用户的所有角色；
     *
     * @param idList id列表
     * @return true-成功,false-失败
     * @throws ApiException 当用户删除失败抛出（用户删除失败）
     * @throws ApiException 当角色删除失败抛出（角色删除失败）
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean batchDelete(List<Integer> idList) {
        boolean b = super.batchDelete(idList);
        if (!b) {
            throw new ApiException("用户删除失败");
        }
        QueryWrapper<UserRoleRelationEntity> wrapperRole = new QueryWrapper<>();
        for (Integer id : idList) {
            wrapperRole.or().eq("user_id", id);
        }
        boolean removeRole = roleRelationService.remove(wrapperRole);
        if (!removeRole) {
            throw new ApiException("用户角色删除失败");
        }
        QueryWrapper<UserGroupRelationEntity> wrapperGroup = new QueryWrapper<>();
        for (Integer id : idList) {
            wrapperGroup.or().eq("user_id", id);
        }
        boolean removeGroup = userGroupRelationService.remove(wrapperGroup);
        if (!removeGroup) {
            throw new ApiException("用户组删除失败");
        }
        return true;
    }

    @Override
    public UserEntity getUserEntity(String userName) {
        return query().eq("user_name", userName).one();
    }

    @Override
    public boolean updateUserPassword(String id, String oldPassword, String newPassword) {
        Assert.hasText(oldPassword,"旧密码不能为空");
        Assert.hasText(newPassword,"新密码不能为空");
        Assert.isTrue(oldPassword.equals(newPassword),"新密码不能与老密码相同");
        // 密码验证
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodeNewPassword = encoder.encode(newPassword);
        boolean matches = encoder.matches(oldPassword, getById(id).getUserPassword());
        Assert.isTrue(matches,"旧密码错误");
        /*
            清理该用户的token盐值
            清理后用户就需要重新登录验证身份
         */
        redisUtils.hdel("SALT",id);
        return lambdaUpdate().eq(UserEntity::getId,id)
                .set(UserEntity::getUserPassword,encodeNewPassword)
                .set(UserEntity::getUserPasswordUpdateTime,LocalDateTime.now())
                .set(UserEntity::getUpdateTime,LocalDateTime.now())
                .update();
    }
}
