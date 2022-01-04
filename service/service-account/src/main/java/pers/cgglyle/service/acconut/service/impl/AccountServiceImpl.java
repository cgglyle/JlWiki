package pers.cgglyle.service.acconut.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pers.cgglyle.common.base.model.BaseDto;
import pers.cgglyle.common.base.model.BaseEntity;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseRelationServiceImpl;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.response.PageResult;
import pers.cgglyle.service.acconut.model.dto.*;
import pers.cgglyle.service.acconut.model.entity.*;
import pers.cgglyle.service.acconut.model.query.PermissionQuery;
import pers.cgglyle.service.acconut.model.query.RoleQuery;
import pers.cgglyle.service.acconut.model.query.UserQuery;
import pers.cgglyle.service.acconut.model.vo.*;
import pers.cgglyle.service.acconut.service.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cgglyle
 * @date 2022-01-04 11:27
 */
@Service
public class AccountServiceImpl extends BaseRelationServiceImpl implements AccountService {
    private final UserService userService;
    private final RoleService roleService;
    private final PermissionService permissionService;
    private final UserRoleRelationService userRoleRelationService;
    private final RolePermissionRelationService rolePermissionRelationService;

    public AccountServiceImpl(UserService userService, RoleService roleService,
                              PermissionService permissionService, UserRoleRelationService userRoleRelationService,
                              RolePermissionRelationService rolePermissionRelationService) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.userRoleRelationService = userRoleRelationService;
        this.rolePermissionRelationService = rolePermissionRelationService;
    }

    /**
     * 获取分页信息
     * <p>
     * 根据请求类型返回分页模型
     * <p>
     * 支持的模型：
     * 1.UserQuery
     * 2.RoleQuery
     * 3.PermissionQuery
     *
     * @param query 请求模型
     * @return 分页模型
     * @throws ApiException 当请求没有被命中抛出"未支持的请求"
     */
    @Override
    public PageResult get(BaseQuery query) {
        if (query instanceof PermissionQuery) {
            Page<PermissionEntity> data = permissionService.get(query);
            return wrapper(data, query, PermissionVo.class);
        }
        if (query instanceof RoleQuery) {
            Page<RoleEntity> data = roleService.get(query);
            return wrapper(data, query, RoleVo.class, o -> {
                List<RolePermissionRelationEntity> relationList = rolePermissionRelationService.getListByRoleId(((RoleVo) o).getId());
                // 获取角色权限关系
                List<RolePermissionRelationVo> collect = relationList.stream().map(relation -> {
                    RolePermissionRelationVo rolePermissionRelationVo = new RolePermissionRelationVo();
                    PermissionEntity permission = permissionService.getById(relation.getPermissionId());
                    rolePermissionRelationVo.setPermission(permission.getPermissionName());
                    BeanUtils.copyProperties(relation, rolePermissionRelationVo);
                    return rolePermissionRelationVo;
                }).collect(Collectors.toList());
                ((RoleVo) o).setPermissionList(collect);
            });
        }
        if (query instanceof UserQuery) {
            Page<UserEntity> page = userService.get(query);
            return wrapper(page, query, UserVo.class, o -> {
                List<UserRoleVo> userRoleList = getUserRoleList(((UserVo) o).getId());
                ((UserVo) o).setUserRole(userRoleList);
            });
        }
        throw new ApiException("未支持的请求");
    }

    @Override
    public boolean add(BaseDto dto) {
        if (dto instanceof RoleAddDto roleAddDto) {
            RoleEntity roleEntity = new RoleEntity();
            BeanUtils.copyProperties(roleAddDto, roleEntity);
            return roleService.add(roleEntity);
        }
        if (dto instanceof PermissionAddDto permissionAddDto) {
            PermissionEntity permissionEntity = new PermissionEntity();
            BeanUtils.copyProperties(permissionAddDto, permissionEntity);
            return permissionService.add(permissionEntity);
        }
        if (dto instanceof RolePermissionRelationAddDto rolePermissionRelationAddDto) {
            RolePermissionRelationEntity rolePermissionRelationEntity = new RolePermissionRelationEntity();
            BeanUtils.copyProperties(rolePermissionRelationAddDto, rolePermissionRelationEntity);
            return rolePermissionRelationService.add(rolePermissionRelationEntity);
        }
        if (dto instanceof UserAddDto userAddDto) {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userAddDto, userEntity);
            return userService.add(userEntity);
        }
        if (dto instanceof UserRoleRelationAddDto userRoleRelationAddDto) {
            UserRoleRelationEntity userRoleRelationEntity = new UserRoleRelationEntity();
            BeanUtils.copyProperties(userRoleRelationAddDto, userRoleRelationEntity);
            return userRoleRelationService.add(userRoleRelationEntity);
        }
        throw new ApiException("未支持的请求");
    }

    @Override
    public boolean update(BaseDto dto) {
        if (dto instanceof RoleUpdateDto roleUpdateDto) {
            RoleEntity roleEntity = new RoleEntity();
            BeanUtils.copyProperties(roleUpdateDto, roleEntity);
            return roleService.update(roleEntity);
        }
        if (dto instanceof UserUpdateDto userUpdateDto) {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userUpdateDto, userEntity);
            return userService.update(userEntity);
        }
        throw new ApiException("未支持的请求");
    }

    @Override
    public boolean delete(BaseDto dto) {
        if (dto instanceof RoleDeleteDto deleteDto) {
            return roleService.delete(deleteDto.getId());
        }
        if (dto instanceof UserDeleteDto userDeleteDto) {
            return userService.delete(userDeleteDto.getId());
        }
        if (dto instanceof PermissionDeleteDto deleteDto) {
            return permissionService.delete(deleteDto.getId());
        }
        if (dto instanceof RolePermissionRelationDeleteDto deleteDto) {
            return rolePermissionRelationService.delete(deleteDto.getId());
        }
        if (dto instanceof UserRoleRelationDeleteDto deleteDto) {
            return userRoleRelationService.delete(deleteDto.getId());
        }
        throw new ApiException("未支持的请求");
    }

    @Override
    public boolean batchDelete(BaseDto dto) {
        if (dto instanceof RoleDeleteDto deleteDto) {
            return roleService.batchDelete(deleteDto.getIdList());
        }
        if (dto instanceof UserDeleteDto userDeleteDto) {
            return userService.batchDelete(userDeleteDto.getIdList());
        }
        if (dto instanceof PermissionDeleteDto deleteDto) {
            return permissionService.batchDelete(deleteDto.getIdList());
        }
        if (dto instanceof RolePermissionRelationDeleteDto deleteDto) {
            return rolePermissionRelationService.batchDelete(deleteDto.getIdList());
        }
        if (dto instanceof UserRoleRelationDeleteDto deleteDto) {
            return userRoleRelationService.batchDelete(deleteDto.getIdList());
        }
        throw new ApiException("未支持的请求");
    }

    @Override
    public List<String> getRoleList(String url) {
        PermissionEntity permissionEntity = permissionService.lambdaQuery()
                .eq(PermissionEntity::getPermissionUrl, url)
                .one();
        if (permissionEntity == null) {
            return null;
        }
        List<RolePermissionRelationEntity> relationList = rolePermissionRelationService.lambdaQuery()
                .eq(RolePermissionRelationEntity::getPermissionId, permissionEntity.getId())
                .list();
        List<String> roleString = new ArrayList<>();
        relationList.forEach(relation -> {
            RoleEntity one = roleService.lambdaQuery().eq(RoleEntity::getId, relation.getRoleId()).one();
            roleString.add(one.getRoleName());
        });
        return roleString;
    }

    @Override
    public List<UserRoleVo> getUserRoleList(Serializable id) {
        List<UserRoleRelationEntity> list = userRoleRelationService.lambdaQuery().eq(UserRoleRelationEntity::getUserId, id).list();
        List<UserRoleVo> roleList = new ArrayList<>();
        list.forEach(role -> {
            RoleEntity roleEntity = roleService.lambdaQuery().eq(BaseEntity::getId, role.getRoleId()).one();
            UserRoleVo userRoleVo = new UserRoleVo();
            userRoleVo.setId(role.getId());
            userRoleVo.setRoleName(roleEntity.getRoleName());
            roleList.add(userRoleVo);
        });
        return roleList;
    }

    @Override
    public boolean updateUserPassword(String id, String oldPassword, String newPassword) {
        return userService.updateUserPassword(id, oldPassword, newPassword);
    }

    @Override
    public UserEntity getUserEntity(String userName) {
        return userService.getUserEntity(userName);
    }
}
