package pers.cgglyle.authenticate.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseEntity;

/**
 * 用户组实体
 *
 * @author cgglyle
 * @date 2021-12-10 09:53
 */
@ApiModel("用户组实体")
@Data
@EqualsAndHashCode(callSuper = true)
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
}
