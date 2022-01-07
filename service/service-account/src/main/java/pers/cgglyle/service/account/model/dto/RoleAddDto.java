package pers.cgglyle.service.account.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseAddDto;

/**
 * 角色添加模型
 *
 * @author cgglyle
 * @date 2021-12-08 14:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleAddDto extends BaseAddDto {
    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDescription;
}
