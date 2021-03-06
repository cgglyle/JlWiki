package pers.cgglyle.authenticate.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseEntity;

/**
 * (Permission)实体类
 *
 * @author cgglyle
 * @since 2021-12-29 14:20:51
 */

@Schema(description = "Permission实体类")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("permission")
public class PermissionEntity extends BaseEntity {

    /**
     * 资源名称
     */
    @Schema(description = "资源名称")
    @TableField("permission_name")
    private String permissionName;

    /**
     * 资源地址
     */
    @Schema(description = "资源地址")
    @TableField("permission_url")
    private String permissionUrl;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    @TableField("update_user")
    private Integer updateUser;
}

