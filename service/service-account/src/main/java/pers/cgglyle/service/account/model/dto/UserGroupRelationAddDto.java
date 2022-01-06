package pers.cgglyle.service.account.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseDto;

/**
 * 用户用户组添加模型
 *
 * @author cgglyle
 * @date 2021-12-13 11:04
 */
public class UserGroupRelationAddDto extends BaseDto {
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 用户组id
     */
    @ApiModelProperty("用户组id")
    private Integer groupId;

    @TableField("is_deleted")
    private boolean isDeleted;

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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
