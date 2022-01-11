package pers.cgglyle.authenticate.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseEntity;

/**
 * 角色权限关联表(RolePermission)实体类
 *
 * @author cgglyle
 * @since 2021-12-29 14:25:08
 */

@ApiModel("RolePermission实体类")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("role_permission_relation")
public class RolePermissionRelationEntity extends BaseEntity {

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    @TableField("role_id")
    private Integer roleId;

    /**
     * 权限id
     */
    @ApiModelProperty("权限id")
    @TableField("permission_id")
    private Integer permissionId;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    @TableField("update_user")
    private Integer updateUser;
}

