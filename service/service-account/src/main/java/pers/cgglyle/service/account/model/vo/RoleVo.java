package pers.cgglyle.service.account.model.vo;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseVo;

import java.util.List;

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

    @ApiModelProperty("修改者")
    private String updateUser;

    @ApiModelProperty("权限列表")
    private List<RolePermissionRelationVo> permissionList;

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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public List<RolePermissionRelationVo> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<RolePermissionRelationVo> permissionList) {
        this.permissionList = permissionList;
    }
}
