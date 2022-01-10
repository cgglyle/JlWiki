package pers.cgglyle.authenticate.service;

import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.authenticate.model.entity.RolePermissionRelationEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-29 14:31
 */
public interface RolePermissionRelationService extends IBaseService<RolePermissionRelationEntity> {

    /**
     * 根据id获取角色权限关系列表
     *
     * @param id 角色id
     * @return 角色权限关系列表
     */
    List<RolePermissionRelationEntity> getListByRoleId(Serializable id);

    /**
     * 根据id删除角色权限关系
     *
     * @param id 角色id
     * @return 成功失败
     */
    boolean deleteByRoleId(Serializable id);

    /**
     * 根据id删除角色权限关系
     * @param id 权限id
     * @return 成功失败
     */
    boolean deleteByPermissionId(Serializable id);
}
