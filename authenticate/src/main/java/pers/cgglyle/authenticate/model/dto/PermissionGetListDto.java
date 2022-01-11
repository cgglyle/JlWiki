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
@ApiModel("Permission实体类")
public class PermissionGetListDto {

    @ApiModelProperty("主键id")
    private Integer id;

    /**
     * 资源名称
     */
    @ApiModelProperty("资源名称")
    private String permissionName;

    /**
     * 资源地址
     */
    @ApiModelProperty("资源地址")
    private String permissionUrl;

}

