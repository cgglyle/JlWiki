package pers.cgglyle.authenticate.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 权限列表模型
 *
 * @author cgglyle
 * @since 2021-12-29 14:20:51
 */
@Data
@Schema(description = "Permission实体类")
public class PermissionGetListDto {

    @Schema(description = "主键id")
    private Integer id;

    /**
     * 资源名称
     */
    @Schema(description = "资源名称")
    private String permissionName;

    /**
     * 资源地址
     */
    @Schema(description = "资源地址")
    private String permissionUrl;

}

