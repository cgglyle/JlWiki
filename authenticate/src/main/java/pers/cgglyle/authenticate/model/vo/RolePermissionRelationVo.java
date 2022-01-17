package pers.cgglyle.authenticate.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 角色权限关联表(RolePermission)显示类
 *
 * @author cgglyle
 * @since 2021-12-29 14:25:08
 */
@Data
@Schema(description = "RolePermission实体类")
public class RolePermissionRelationVo {

    @Schema(description = "主键id")
    private Integer id;

    /**
     * 权限id
     */
    @Schema(description = "权限名")
    private String permission;

}

