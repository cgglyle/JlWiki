package pers.cgglyle.authenticate.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseAddDto;

/**
 * 角色权限关联表(RolePermission)添加模型
 *
 * @author cgglyle
 * @since 2021-12-29 14:25:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("RolePermission添加模型")
public class RolePermissionRelationAddDto extends BaseAddDto {

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Integer roleId;

    /**
     * 权限id
     */
    @ApiModelProperty("权限id")
    private Integer permissionId;

}

