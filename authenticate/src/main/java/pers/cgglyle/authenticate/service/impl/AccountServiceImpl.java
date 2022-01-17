package pers.cgglyle.authenticate.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.cgglyle.authenticate.model.dto.*;
import pers.cgglyle.authenticate.model.entity.*;
import pers.cgglyle.authenticate.model.query.GroupQuery;
import pers.cgglyle.authenticate.model.query.PermissionQuery;
import pers.cgglyle.authenticate.model.query.RoleQuery;
import pers.cgglyle.authenticate.model.query.UserQuery;
import pers.cgglyle.authenticate.model.vo.*;
import pers.cgglyle.authenticate.service.*;
import pers.cgglyle.common.base.model.BaseDto;
import pers.cgglyle.common.base.model.BaseEntity;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseRelationServiceImpl;
import pers.cgglyle.common.response.ApiException;
import pers.cgglyle.common.response.PageResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 账号服务实现
 *
 * <p> 这是一个标准的外观模式，同时符合最少知识原则
 * <p> 提供User信息、Role信息、Permission信息
 *
 * @author cgglyle
 * @date 2022-01-04 11:27
 */
@Service
public class AccountServiceImpl extends BaseRelationServiceImpl implements AccountService {
    private final UserService userService;
    private final RoleService roleService;
    private final PermissionService permissionService;
    private final GroupService groupService;
    private final UserRoleRelationService userRoleRelationService;
    private final RolePermissionRelationService rolePermissionRelationService;

    public AccountServiceImpl(UserService userService,
                              RoleService roleService,
                              PermissionService permissionService,
                              UserRoleRelationService userRoleRelationService,
                              RolePermissionRelationService rolePermissionRelationService,
                              GroupService groupService) {
        this.userService = userService;
        this.roleService = roleService;
        this.groupService = groupService;
        this.permissionService = permissionService;
        this.userRoleRelationService = userRoleRelationService;
        this.rolePermissionRelationService = rolePermissionRelationService;
    }

    /**
     * 获取分页信息
     * <p> 根据请求类型返回分页模型
     * <p> 支持的模型：
     * <ul>
     * <li> {@code UserQuery}
     * <li> {@code RoleQuery}
     * <li> {@code PermissionQuery}
     * </ul>
     *
     * @param query 请求模型
     * @return 分页模型
     * @throws ApiException 当请求没有被命中抛出"未支持的请求"
     */
    @Override
    public PageResult get(BaseQuery query) throws IllegalAccessException {
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
        if (query instanceof GroupQuery) {
            Page<GroupEntity> page = groupService.get(query);
            return wrapper(page, query, GroupVo.class);
        }
        throw new ApiException("未支持的请求");
    }

    /**
     * 添加数据
     * <p> 根据添加的请求分类
     * <p> 支持的模型:
     * <ul>
     * <li> {@code RoleAddDto}
     * <li> {@code PermissionAddDto}
     * <li> {@code UserAddDto}
     * <li> {@code RolePermissionRelationAddDto}
     * <li> {@code UserRoleRelationAddDto}
     * </ul>
     *
     * @param dto 添加请求模型
     * @return 成功失败
     */
    @Transactional
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
            // 角色统计加一
            RoleEntity roleEntity = roleService.lambdaQuery().select(RoleEntity::getRoleUserCount)
                    .eq(RoleEntity::getId, userRoleRelationAddDto.getRoleId()).one();
            boolean update = roleService.lambdaUpdate().eq(RoleEntity::getId, userRoleRelationAddDto.getRoleId())
                    .set(RoleEntity::getRoleUserCount, roleEntity.getRoleUserCount() + 1).update();
            if (!update) {
                throw new ApiException("角色拥有人数更新失败");
            }
            return userRoleRelationService.add(userRoleRelationEntity);
        }
        if (dto instanceof GroupAddDto addDto) {
            GroupEntity groupEntity = new GroupEntity();
            BeanUtils.copyProperties(addDto, groupEntity);
            return groupService.add(groupEntity);
        }
        throw new ApiException("未支持的请求");
    }

    /**
     * 更新数据
     * <p> 根据请求更新数据
     * <p> 支持的模型:
     * <ul>
     * <li> {@code RoleUpdateDto}
     * <li> {@code UserUpdateDto}
     * </ul>
     *
     * @param dto 更新请求模型
     * @return 成功失败
     */
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

    /**
     * 删除数据
     * <p> 根据请求删除数据
     * <p> 支持的模型:
     * <ul>
     * <li> {@code RoleDeleteDto}
     * <li> {@code UserDeleteDto}
     * <li> {@code PermissionDeleteDto}
     * <li> {@code RolePermissionRelationDeleteDto}
     * <li> {@code UserRoleRelationDeleteDto}
     * </ul>
     *
     * @param dto 删除请求模型
     * @return 成功失败
     */
    @Transactional
    @Override
    public boolean delete(BaseDto dto) {
        if (dto instanceof RoleDeleteDto deleteDto) {
            // 删除角色同时删除关系表中的数据
            // 角色用户关系表
            userRoleRelationService.deleteByRoleId(deleteDto.getId());
            // 角色权限关系表
            rolePermissionRelationService.deleteByRoleId(deleteDto.getId());
            return roleService.delete(deleteDto.getId());
        }
        if (dto instanceof UserDeleteDto deleteDto) {
            // 角色统计减一
            List<UserRoleRelationEntity> userRoleList = userRoleRelationService.lambdaQuery()
                    .eq(UserRoleRelationEntity::getUserId, deleteDto.getId()).list();
            userRoleList.forEach(userRoleRelationEntity -> {
                RoleEntity one = roleService.lambdaQuery().eq(RoleEntity::getId, userRoleRelationEntity.getRoleId()).one();
                boolean update = roleService.lambdaUpdate().eq(RoleEntity::getId, userRoleRelationEntity.getRoleId())
                        .set(RoleEntity::getRoleUserCount, one.getRoleUserCount() - 1).update();
                if (!update) {
                    throw new ApiException("角色拥有人数更新失败");
                }
            });
            // 删除用户角色关系表
            userRoleRelationService.deleteByUserId(deleteDto.getId());
            return userService.delete(deleteDto.getId());
        }
        if (dto instanceof PermissionDeleteDto deleteDto) {
            // 删除角色权限关系表
            rolePermissionRelationService.deleteByPermissionId(deleteDto.getId());
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

    /**
     * 批量删除数据
     * <p>
     * 根据请求批量删除数据
     *
     * @param dto 删除请求模型
     * @return 成功失败
     */
    @Override
    public boolean batchDelete(BaseDto dto) {
        if (dto instanceof RoleDeleteDto deleteDto) {
            List<Serializable> idList = deleteDto.getIdList();
            idList.forEach(id -> {
                // 删除角色用户关系
                userRoleRelationService.deleteByRoleId(id);
                // 删除角色权限关系
                rolePermissionRelationService.deleteByRoleId(id);
            });
            return roleService.batchDelete(deleteDto.getIdList());
        }
        if (dto instanceof UserDeleteDto deleteDto) {
            List<Serializable> idList = deleteDto.getIdList();
            // 删除用户角色关系
            idList.forEach(userRoleRelationService::deleteByUserId);
            return userService.batchDelete(deleteDto.getIdList());
        }
        if (dto instanceof PermissionDeleteDto deleteDto) {
            List<Serializable> idList = deleteDto.getIdList();
            // 删除角色权限关系
            idList.forEach(rolePermissionRelationService::deleteByPermissionId);
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

    /**
     * 根据Permission中的url获取角色
     *
     * @param url 请求url
     * @return 角色列表
     */
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

    /**
     * 根据用户id获取角色列表
     *
     * @param id 用户id
     * @return 角色列表
     */
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
    public boolean updateUserPassword(Serializable id, String oldPassword, String newPassword) {
        return userService.updateUserPassword(id, oldPassword, newPassword);
    }

    @Override
    public UserEntity getUserEntity(String userName) {
        return userService.getUserEntity(userName);
    }
}
