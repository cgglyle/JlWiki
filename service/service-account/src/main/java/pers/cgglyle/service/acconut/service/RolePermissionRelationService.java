package pers.cgglyle.service.acconut.service;

import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.service.acconut.model.entity.RolePermissionRelationEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-29 14:31
 */
public interface RolePermissionRelationService extends IBaseService<RolePermissionRelationEntity> {


    List<RolePermissionRelationEntity> getListByRoleId(Serializable id);
}
