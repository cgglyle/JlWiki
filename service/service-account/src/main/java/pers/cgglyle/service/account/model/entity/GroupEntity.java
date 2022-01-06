package pers.cgglyle.service.account.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseEntity;

import java.util.Objects;

/**
 * 用户组实体
 *
 * @author cgglyle
 * @date 2021-12-10 09:53
 */
@ApiModel("用户组实体")
@TableName("user_groups")
public class GroupEntity extends BaseEntity {
    @ApiModelProperty("用户组名称")
    @TableField("group_name")
    private String groupName;

    @ApiModelProperty("用户组描述")
    @TableField("group_description")
    private String groupDescription;

    @ApiModelProperty("修改者")
    @TableField("update_user")
    private Integer updateUser;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
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
        GroupEntity that = (GroupEntity) o;
        return Objects.equals(groupName, that.groupName) && Objects.equals(groupDescription, that.groupDescription) && Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupName, groupDescription, updateUser);
    }
}
