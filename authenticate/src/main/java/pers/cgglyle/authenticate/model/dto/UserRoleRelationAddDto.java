package pers.cgglyle.authenticate.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseAddDto;

/**
 * 用户添加角色模型
 *
 * @author cgglyle
 * @date 2021-12-09 09:28
 */
@ApiModel("用户添加角色模型")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRoleRelationAddDto extends BaseAddDto {
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("角色id")
    private Integer roleId;
}
