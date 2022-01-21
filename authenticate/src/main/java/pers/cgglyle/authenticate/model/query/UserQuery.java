package pers.cgglyle.authenticate.model.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.annotaion.QueryModel;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.constant.enums.QueryModelEnum;

/**
 * 用户查询体
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQuery extends BaseQuery {
    @QueryModel(QueryModelEnum.EQ)
    @Schema(description = "账户名")
    private String userName;
    @QueryModel(QueryModelEnum.EQ)
    @Schema(description = "电话")
    private String phone;
    @Schema(description = "昵称")
    private String userNickName;
    @Schema(description = "邮箱")
    private String userEmail;
    @QueryModel(QueryModelEnum.EQ)
    @Schema(description = "性别")
    private Integer userGender;
    @Schema(description = "用户角色")
    private String userRole;
    @Schema(description = "用户组")
    private String userGroup;
}
