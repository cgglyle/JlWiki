package pers.cgglyle.service.acconut.model.vo;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.base.model.BaseVo;

import java.util.Objects;

/**
 * 角色显示
 *
 * @author cgglyle
 * @date 2021/12/7
 */
public class RoleVo extends BaseVo {
    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDescription;

    @ApiModelProperty("当前角色用户数量")
    private Integer roleUserCount;

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

    public Integer getRoleUserCount() {
        return roleUserCount;
    }

    public void setRoleUserCount(Integer roleUserCount) {
        this.roleUserCount = roleUserCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoleVo roleVo = (RoleVo) o;
        return Objects.equals(roleName, roleVo.roleName) && Objects.equals(roleDescription, roleVo.roleDescription) && Objects.equals(roleUserCount, roleVo.roleUserCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleName, roleDescription, roleUserCount);
    }
}
