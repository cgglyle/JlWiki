package pers.cgglyle.authenticate.model.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseQuery;

/**
 * 分页请求
 *
 * @author cgglyle
 * @date 2021-12-08 13:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleQuery extends BaseQuery {
    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色描述")
    private String roleDescription;

    @Schema(description = "修改者")
    private String updateUser;
}
