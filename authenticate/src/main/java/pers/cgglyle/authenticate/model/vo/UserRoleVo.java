package pers.cgglyle.authenticate.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色显示模型
 *
 * @author cgglyle
 * @date 2021-12-09 13:40
 */
@Data
public class UserRoleVo {
    /**
     * UserRoleRelation 主键 ID
     */
    @ApiModelProperty("主键id")
    private Serializable id;
    @ApiModelProperty("角色名")
    private String roleName;

}
