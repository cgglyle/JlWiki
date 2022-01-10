package pers.cgglyle.authenticate.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseUpdateDto;

/**
 * 更新角色模型
 *
 * @author cgglyle
 * @date 2021-12-08 14:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleUpdateDto extends BaseUpdateDto {
    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDescription;

    @ApiModelProperty("修改者")
    private Integer updateUser;

}
