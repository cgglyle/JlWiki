package pers.cgglyle.service.account.model.vo;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDescription;

    @ApiModelProperty("当前角色用户数量")
    private Integer roleUserCount;

    @ApiModelProperty("修改者")
    private String updateUser;

    @ApiModelProperty("权限列表")
    private List<RolePermissionRelationVo> permissionList;

}
