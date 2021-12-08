package pers.cgglyle.service.acconut.model.dto;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.base.model.BaseDto;

import java.util.Objects;

/**
 * 角色添加模型
 *
 * @author cgglyle
 * @date 2021-12-08 14:01
 */
public class RoleAddDto extends BaseDto {
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
        if (!super.equals(o)) return false;
        RoleAddDto that = (RoleAddDto) o;
        return Objects.equals(roleName, that.roleName) && Objects.equals(roleDescription, that.roleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleName, roleDescription);
    }
}
