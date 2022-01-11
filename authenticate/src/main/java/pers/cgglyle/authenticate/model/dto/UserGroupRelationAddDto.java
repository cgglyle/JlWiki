package pers.cgglyle.authenticate.model.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseDto;

/**
 * 用户用户组添加模型
 *
 * @author cgglyle
 * @date 2021-12-13 11:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserGroupRelationAddDto extends BaseDto {
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 用户组id
     */
    @ApiModelProperty("用户组id")
    private Integer groupId;

    @TableField("is_deleted")
    private boolean isDeleted;

}
