package pers.cgglyle.service.acconut.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * 更新角色模型
 *
 * @author cgglyle
 * @date 2021-12-08 14:09
 */
public class RoleUpdateDto {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUpdateDto that = (RoleUpdateDto) o;
        return Objects.equals(roleName, that.roleName) && Objects.equals(roleDescription, that.roleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName, roleDescription);
    }
}
