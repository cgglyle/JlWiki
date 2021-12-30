package pers.cgglyle.service.acconut.service;

import pers.cgglyle.common.base.service.IBaseService;
import pers.cgglyle.service.acconut.model.dto.RolePermissionRelationDto;
import pers.cgglyle.service.acconut.model.entity.RolePermissionRelationEntity;
import pers.cgglyle.service.acconut.model.vo.RolePermissionRelationVo;

import java.util.List;

/**
 * @author cgglyle
 * @date 2021-12-29 14:31
 */
public interface RolePermissionRelationService extends IBaseService<RolePermissionRelationEntity> {

    /**
     * 给角色添加权限
     *
     * @param rolePermissionRelationDto 角色权限实体
     * @return 成功失败
     */
    boolean add(RolePermissionRelationDto rolePermissionRelationDto);

    /**
     * 获得权限列表
     *
     * @param roleId 角色id
     * @return 显示实体
     */
    List<RolePermissionRelationVo> getPermissionList(Integer roleId);

}
