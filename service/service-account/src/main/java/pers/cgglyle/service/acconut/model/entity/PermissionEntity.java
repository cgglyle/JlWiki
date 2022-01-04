package pers.cgglyle.service.acconut.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseEntity;

/**
 * (Permission)实体类
 *
 * @author cgglyle
 * @since 2021-12-29 14:20:51
 */

@ApiModel("Permission实体类")
@TableName("permission")
public class PermissionEntity extends BaseEntity {

    /**
     * 资源名称
     */
    @ApiModelProperty("资源名称")
    @TableField("permission_name")
    private String permissionName;

    /**
     * 资源地址
     */
    @ApiModelProperty("资源地址")
    @TableField("permission_url")
    private String permissionUrl;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    @TableField("update_user")
    private Integer updateUser;


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

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

}

