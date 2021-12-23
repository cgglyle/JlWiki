package pers.cgglyle.service.acconut.model.dto;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseDto;

import java.util.Objects;

/**
 * 用户组添加模型
 *
 * @author cgglyle
 * @date 2021-12-10 11:40
 */
public class GroupAddDto extends BaseDto {
    @ApiModelProperty("用户组名称")
    private String groupName;

    @ApiModelProperty("用户组描述")
    private String groupDescription;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GroupAddDto that = (GroupAddDto) o;
        return Objects.equals(groupName, that.groupName) && Objects.equals(groupDescription, that.groupDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupName, groupDescription);
    }
}
