package pers.cgglyle.authenticate.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseUpdateDto;

/**
 * 用户组更新模型
 *
 * @author cgglyle
 * @date 2021-12-10 11:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GroupUpdateDto extends BaseUpdateDto {
    @Schema(description = "用户组名称")
    private String groupName;

    @Schema(description = "用户组描述")
    private String groupDescription;

    @Schema(description = "修改者")
    private Integer updateUser;
}
