package pers.cgglyle.authenticate.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseEntity;

/**
 * 用户组用户实体
 *
 * @author cgglyle
 * @date 2021-12-10 13:30
 */
@ApiModel("用户组用户实体")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user_group_relation")
public class UserGroupRelationEntity extends BaseEntity {
    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("用户组id")
    @TableField("group_id")
    private Integer groupId;
}
