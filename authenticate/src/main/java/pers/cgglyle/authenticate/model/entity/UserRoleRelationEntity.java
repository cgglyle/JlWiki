package pers.cgglyle.authenticate.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseEntity;

/**
 * 用户角色关系实体
 *
 * @author cgglyle
 * @date 2021-12-08 14:20
 */
@ApiModel("用户角色实体")
@Data
@EqualsAndHashCode(callSuper = true)
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
}