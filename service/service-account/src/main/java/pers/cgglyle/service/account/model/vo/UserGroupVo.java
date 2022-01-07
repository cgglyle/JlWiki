package pers.cgglyle.service.account.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户组显示模型
 *
 * @author cgglyle
 * @date 2021-12-13 11:48
 */
@Data
@AllArgsConstructor
public class UserGroupVo {
    /**
     * UserGroupRelation 主键 ID
     */
    @ApiModelProperty("主键id")
    private Serializable id;
    @ApiModelProperty("角色名")
    private String groupName;
}
