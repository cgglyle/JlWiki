package pers.cgglyle.service.acconut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.annotaion.RedisCache;
import pers.cgglyle.common.base.service.impl.BaseServiceImpl;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.service.acconut.mapper.UserRoleRelationMapper;
import pers.cgglyle.service.acconut.model.dto.UserRoleRelationDto;
import pers.cgglyle.service.acconut.model.entity.RoleEntity;
import pers.cgglyle.service.acconut.model.entity.UserRoleRelationEntity;
import pers.cgglyle.service.acconut.model.vo.UserRoleVo;
import pers.cgglyle.service.acconut.service.RoleService;
import pers.cgglyle.service.acconut.service.UserRoleRelationService;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色服务层实现
 *
 * @author cgglyle
 * @date 2021-12-08 16:01
 */
@Service
public class UserRoleRelationServiceImpl extends BaseServiceImpl<UserRoleRelationMapper, UserRoleRelationEntity> implements UserRoleRelationService {

    private final RoleService roleService;

    public UserRoleRelationServiceImpl(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public List<UserRoleVo> getUserRoleList(Integer userId) {
        QueryWrapper<UserRoleRelationEntity> tempWrapper = new QueryWrapper<>();
        // 根据 user_id 从 user_role_relation 表中精确查出 role_id
        tempWrapper.select("role_id", "id").eq("user_id", userId);
        List<UserRoleRelationEntity> roleRelationList = this.list(tempWrapper);
        List<UserRoleVo> roleList = new ArrayList<>();
        for (UserRoleRelationEntity userRoleRelationEntity : roleRelationList) {
            RoleEntity roleEntity = roleService.getById(userRoleRelationEntity.getRoleId());
            roleList.add(new UserRoleVo(userRoleRelationEntity.getId(), roleEntity.getRoleName()));
        }
        return roleList;
    }

    @Override
    public List<Integer> getUserIdList(String roleName) {
        QueryWrapper<RoleEntity> tempWrapper = new QueryWrapper<>();
        // 从 role 表中获取 roleID
        tempWrapper.select("id").like("role_name", roleName);
        List<RoleEntity> list = roleService.list(tempWrapper);
        QueryWrapper<UserRoleRelationEntity> userRoleRelationEntityQueryWrapper = new QueryWrapper<>();
        for (RoleEntity roleEntity : list) {
            // 根据 roleId 从 user_role_relation 表中精确查出 userId 列表
            userRoleRelationEntityQueryWrapper.or().eq("id", roleEntity.getId());
        }
        List<UserRoleRelationEntity> userRoleRelationEntities = this.list(userRoleRelationEntityQueryWrapper);
        ArrayList<Integer> userIdList = new ArrayList<>();
        for (UserRoleRelationEntity userRoleRelation : userRoleRelationEntities) {
            // 将 userId实体中的 id 提取到单独了 List 并返回
            userIdList.add(userRoleRelation.getUserId());
        }
        return userIdList;
    }

    @Override
    public boolean addUserRole(UserRoleRelationDto userRoleRelationDto) {
        List<UserRoleVo> userRoleList = this.getUserRoleList(userRoleRelationDto.getUserId());
        userRoleList.forEach(userRoleVo -> {
            if (this.baseMapper.selectById(userRoleVo.getId()) != null) {
                throw new ApiException("已有此角色");
            }
        });
        UserRoleRelationEntity userRoleRelationEntity = new UserRoleRelationEntity();
        BeanUtils.copyProperties(userRoleRelationDto, userRoleRelationEntity);
        return add(userRoleRelationEntity);
    }
}
