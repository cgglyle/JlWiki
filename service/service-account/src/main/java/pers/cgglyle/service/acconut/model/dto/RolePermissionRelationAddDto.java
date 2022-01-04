package pers.cgglyle.service.acconut.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseDto;

/**
 * 角色权限关联表(RolePermission)添加模型
 *
 * @author cgglyle
 * @since 2021-12-29 14:25:08
 */

@ApiModel("RolePermission添加模型")
public class RolePermissionRelationAddDto extends BaseDto {

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Integer roleId;

    /**
     * 权限id
     */     
    @ApiModelProperty("权限id")
    private Integer permissionId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}

