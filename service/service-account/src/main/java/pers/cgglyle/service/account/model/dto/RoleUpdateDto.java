package pers.cgglyle.service.account.model.dto;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseUpdateDto;

/**
 * 更新角色模型
 *
 * @author cgglyle
 * @date 2021-12-08 14:09
 */
public class RoleUpdateDto extends BaseUpdateDto {
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
}
