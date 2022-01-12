package pers.cgglyle.authenticate.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseEntity;

/**
 * 角色实体
 *
 * @author cgglyle
 * @date 2021/12/7
 */
@Schema(description = "角色实体")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("role")
public class RoleEntity extends BaseEntity {
    @Schema(description = "角色名称")
    @TableField("role_name")
    private String roleName;

    @Schema(description = "角色描述")
    @TableField("role_description")
    private String roleDescription;

    @Schema(description = "当前角色用户数量")
    @TableField("role_user_count")
    private Integer roleUserCount;

    @Schema(description = "修改者")
    @TableField("update_user")
    private Integer updateUser;
}
