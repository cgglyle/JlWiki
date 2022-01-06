package pers.cgglyle.service.account.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseAddDto;

/**
 * 用户添加角色模型
 *
 * @author cgglyle
 * @date 2021-12-09 09:28
 */
@ApiModel("用户添加角色模型")
public class UserRoleRelationAddDto extends BaseAddDto {
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("角色id")
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
