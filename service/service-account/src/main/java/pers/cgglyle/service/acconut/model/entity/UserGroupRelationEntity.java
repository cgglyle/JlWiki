package pers.cgglyle.service.acconut.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.base.model.BaseEntity;

import java.util.Objects;

/**
 * 用户组用户实体
 *
 * @author cgglyle
 * @date 2021-12-10 13:30
 */
@ApiModel("用户组用户实体")
public class UserGroupRelationEntity extends BaseEntity {
    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("用户组id")
    @TableField("group_id")
    private Integer groupId;

    @ApiModelProperty("修改人")
    @TableField("update_user")
    private Integer updateUser;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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
        if (!super.equals(o)) return false;
        UserGroupRelationEntity that = (UserGroupRelationEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(groupId, that.groupId) && Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, groupId, updateUser);
    }
}
