package pers.cgglyle.service.account.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseQuery;

/**
 * (Permission)实体类
 *
 * @author cgglyle
 * @since 2021-12-29 14:20:51
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("Permission实体类")
public class PermissionQuery extends BaseQuery {

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

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private Integer updateUser;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Integer createUser;
}

