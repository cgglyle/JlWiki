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

    @ApiModelProperty("修改者")
    private Integer updateUser;

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

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUpdateDto that = (RoleUpdateDto) o;
        return Objects.equals(roleName, that.roleName) && Objects.equals(roleDescription, that.roleDescription) && Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName, roleDescription, updateUser);
    }
}
