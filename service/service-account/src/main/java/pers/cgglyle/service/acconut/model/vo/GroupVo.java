package pers.cgglyle.service.acconut.model.vo;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseVo;

import java.util.Objects;

/**
 * @author cgglyle
 * @date 2021-12-10 10:12
 */
public class GroupVo extends BaseVo {
    @ApiModelProperty("用户组名称")
    private String groupName;

    @ApiModelProperty("用户组描述")
    private String groupDescription;

    @ApiModelProperty("修改者")
    private String updateUser;

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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GroupVo groupVo = (GroupVo) o;
        return Objects.equals(groupName, groupVo.groupName) && Objects.equals(groupDescription, groupVo.groupDescription) && Objects.equals(updateUser, groupVo.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupName, groupDescription, updateUser);
    }
}
