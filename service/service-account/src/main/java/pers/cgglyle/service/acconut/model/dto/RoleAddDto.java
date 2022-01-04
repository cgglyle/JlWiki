package pers.cgglyle.service.acconut.model.dto;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseAddDto;

/**
 * 角色添加模型
 *
 * @author cgglyle
 * @date 2021-12-08 14:01
 */
public class RoleAddDto extends BaseAddDto {
    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDescription;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
