package pers.cgglyle.authenticate.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseVo;

/**
 * (Permission)显示模型
 *
 * @author cgglyle
 * @since 2021-12-29 14:20:51
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Permission实体类")
public class PermissionVo extends BaseVo {

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

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private Integer updateUser;

}

