package pers.cgglyle.service.account.model.query;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseQuery;

import java.util.Objects;

/**
 * 分页请求
 *
 * @author cgglyle
 * @date 2021-12-08 13:14
 */
public class RoleQuery extends BaseQuery {
    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDescription;

    @ApiModelProperty("修改者")
    private String updateUser;

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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleQuery roleQuery = (RoleQuery) o;
        return Objects.equals(roleName, roleQuery.roleName) && Objects.equals(roleDescription, roleQuery.roleDescription) && Objects.equals(updateUser, roleQuery.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName, roleDescription, updateUser);
    }
}