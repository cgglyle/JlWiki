package pers.cgglyle.service.account.model.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseQuery;

/**
 * 用户查询体
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQuery extends BaseQuery {
    @ApiModelProperty("账户名")
    private String userName;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("昵称")
    private String userNickName;
    @ApiModelProperty("邮箱")
    private String userEmail;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("用户角色")
    private String userRole;
    @ApiModelProperty("用户组")
    private String userGroup;
}
