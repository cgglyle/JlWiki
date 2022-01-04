package pers.cgglyle.service.acconut.service;

import pers.cgglyle.common.base.service.BaseRelationService;

import java.util.List;

/**
 * 角色-权限综合服务层
 *
 * @author cgglyle
 * @date 2021-12-30 10:49
 */
public interface RolePermissionService extends BaseRelationService{

    List<String> getRoleList(String url);

}
