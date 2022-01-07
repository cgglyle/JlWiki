package pers.cgglyle.service.account.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseEntity;

/**
 * 角色实体
 *
 * @author cgglyle
 * @date 2021/12/7
 */
@ApiModel("角色实体")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("role")
public class RoleEntity extends BaseEntity {
    @ApiModelProperty("角色名称")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty("角色描述")
    @TableField("role_description")
    private String roleDescription;

    @ApiModelProperty("当前角色用户数量")
    @TableField("role_user_count")
    private Integer roleUserCount;

    @ApiModelProperty("修改者")
    @TableField("update_user")
    private Integer updateUser;
}
