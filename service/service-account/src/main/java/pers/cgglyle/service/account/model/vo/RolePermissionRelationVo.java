package pers.cgglyle.service.account.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色权限关联表(RolePermission)显示类
 *
 * @author cgglyle
 * @since 2021-12-29 14:25:08
 */

@ApiModel("RolePermission实体类")
public class RolePermissionRelationVo {

    @ApiModelProperty("主键id")
    private Integer id;

    /**
     * 权限id
     */
    @ApiModelProperty("权限名")
    private String permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {

        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}

