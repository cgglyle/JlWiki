package pers.cgglyle.authenticate.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseIncrementalEntity;

/**
 * 用户组用户实体
 *
 * @author cgglyle
 * @date 2021-12-10 13:30
 */
@Schema(description = "用户组用户实体")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user_group_relation")
public class UserGroupRelationEntity extends BaseIncrementalEntity {
    @Schema(description = "用户id")
    @TableField("user_id")
    private Integer userId;

    @Schema(description = "用户组id")
    @TableField("group_id")
    private Integer groupId;
}
