package pers.cgglyle.service.acconut.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseEntity;

import java.util.Objects;

/**
 * 用户角色关系实体
 *
 * @author cgglyle
 * @date 2021-12-08 14:20
 */
@ApiModel("用户角色实体")
@TableName("user_role_relation")
public class UserRoleRelationEntity extends BaseEntity {

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("角色ID")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("修改人")
    @TableField("update_user")
    private Integer updateUser;

    @TableField("is_deleted")
    private boolean isDeleted;

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

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean isDeleted() {
        return isDeleted;
    }

    @Override
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserRoleRelationEntity that = (UserRoleRelationEntity) o;
        return isDeleted == that.isDeleted && Objects.equals(userId, that.userId) && Objects.equals(roleId, that.roleId) && Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, roleId, updateUser, isDeleted);
    }
}