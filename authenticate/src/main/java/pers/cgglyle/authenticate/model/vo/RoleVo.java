package pers.cgglyle.authenticate.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseVo;

import java.util.List;

/**
 * 角色显示
 *
 * @author cgglyle
 * @date 2021/12/7
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleVo extends BaseVo {
    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色描述")
    private String roleDescription;

    @Schema(description = "当前角色用户数量")
    private Integer roleUserCount;

    @Schema(description = "修改者")
    private String updateUser;

    @Schema(description = "权限列表")
    private List<RolePermissionRelationVo> permissionList;

}
