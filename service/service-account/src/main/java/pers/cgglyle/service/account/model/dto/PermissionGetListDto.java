package pers.cgglyle.service.account.model.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 权限列表模型
 *
 * @author cgglyle
 * @since 2021-12-29 14:20:51
 */

@ApiModel("Permission实体类")
@TableName("permission")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

