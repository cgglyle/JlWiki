package pers.cgglyle.service.acconut.model.query;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.base.model.BaseQuery;

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
        RoleQuery roleQuery = (RoleQuery) o;
        return Objects.equals(roleName, roleQuery.roleName) && Objects.equals(roleDescription, roleQuery.roleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName, roleDescription);
    }
}
