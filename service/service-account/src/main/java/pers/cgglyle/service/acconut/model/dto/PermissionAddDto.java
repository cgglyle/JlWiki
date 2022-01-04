package pers.cgglyle.service.acconut.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseDto;

/**
 * (Permission)实体类
 *
 * @author cgglyle
 * @since 2021-12-29 14:20:51
 */

@ApiModel("Permission实体类")
public class PermissionAddDto extends BaseDto {

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

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

}

