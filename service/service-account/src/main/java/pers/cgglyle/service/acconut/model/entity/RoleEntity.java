package pers.cgglyle.service.acconut.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.base.model.BaseEntity;

import java.util.Objects;

/**
 * 角色实体
 *
 * @author cgglyle
 * @date 2021/12/7
 */
@ApiModel("角色实体")
public class RoleEntity extends BaseEntity {
    @ApiModelProperty("角色名称")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty("角色描述")
    @TableField("role_description")
    private String roleDescription;

    @ApiModelProperty("当前角色用户数量")
    @TableField("role_user_count")
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
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(roleName, that.roleName) && Objects.equals(roleDescription, that.roleDescription) && Objects.equals(roleUserCount, that.roleUserCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleName, roleDescription, roleUserCount);
    }
}
