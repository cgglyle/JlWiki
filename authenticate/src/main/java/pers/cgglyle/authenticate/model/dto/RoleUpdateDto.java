package pers.cgglyle.authenticate.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色描述")
    private String roleDescription;

    @Schema(description = "修改者")
    private Integer updateUser;

}
