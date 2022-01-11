package pers.cgglyle.authenticate.model.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseQuery;

/**
 * 用户组请求
 *
 * @author cgglyle
 * @date 2021-12-10 10:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GroupQuery extends BaseQuery {
    @Schema(description = "用户组名称")
    private String groupName;

    @Schema(description = "用户组描述")
    private String groupDescription;

    @Schema(description = "修改者")
    private String updateUser;
}
