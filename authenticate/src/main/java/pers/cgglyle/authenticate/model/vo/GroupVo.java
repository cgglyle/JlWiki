package pers.cgglyle.authenticate.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseVo;

/**
 * 用户组显示模型
 *
 * @author cgglyle
 * @date 2021-12-10 10:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GroupVo extends BaseVo {
    @ApiModelProperty("用户组名称")
    private String groupName;

    @ApiModelProperty("用户组描述")
    private String groupDescription;

    @ApiModelProperty("修改者")
    private String updateUser;
}
