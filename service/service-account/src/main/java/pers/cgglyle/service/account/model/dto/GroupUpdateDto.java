package pers.cgglyle.service.account.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * 用户组更新模型
 *
 * @author cgglyle
 * @date 2021-12-10 11:46
 */
public class GroupUpdateDto {
    @ApiModelProperty("用户组名称")
    private String groupName;

    @ApiModelProperty("用户组描述")
    private String groupDescription;

    @ApiModelProperty("修改者")
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
        GroupUpdateDto that = (GroupUpdateDto) o;
        return Objects.equals(groupName, that.groupName) && Objects.equals(groupDescription, that.groupDescription) && Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, groupDescription, updateUser);
    }
}
