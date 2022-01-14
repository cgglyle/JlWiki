package pers.cgglyle.authenticate.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseIncrementalEntity;

/**
 * 用户角色关系实体
 *
 * @author cgglyle
 * @date 2021-12-08 14:20
 */
@Schema(description = "用户角色实体")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user_role_relation")
public class UserRoleRelationEntity extends BaseIncrementalEntity {

    @Schema(description = "用户id")
    @TableField("user_id")
    private Integer userId;

    @Schema(description = "角色ID")
    @TableField("role_id")
    private Integer roleId;

    @Schema(description = "修改人")
    @TableField("update_user")
    private Integer updateUser;

    @TableField("is_deleted")
    private boolean isDeleted;
}