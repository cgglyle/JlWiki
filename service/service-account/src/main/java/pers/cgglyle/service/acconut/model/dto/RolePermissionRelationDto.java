package pers.cgglyle.service.acconut.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseDto;

/**
 * 角色权限关联表(RolePermission)实体类
 *
 * @author cgglyle
 * @since 2021-12-29 14:25:08
 */

@ApiModel("RolePermission实体类")
public class RolePermissionRelationDto extends BaseDto {

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Integer roleId;

    /**
     * 权限id
     */     
    @ApiModelProperty("权限id")
    private Integer permission;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
}

