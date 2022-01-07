package pers.cgglyle.service.account.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户组更新模型
 *
 * @author cgglyle
 * @date 2021-12-10 11:46
 */
@Data
public class GroupUpdateDto {
    @ApiModelProperty("用户组名称")
    private String groupName;

    @ApiModelProperty("用户组描述")
    private String groupDescription;

    @ApiModelProperty("修改者")
    private Integer updateUser;
}
