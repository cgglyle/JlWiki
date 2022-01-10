package pers.cgglyle.authenticate.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.cgglyle.common.base.model.BaseUpdateDto;

import javax.validation.constraints.NotNull;

/**
 * 用户更新数据模型
 *
 * @author cgglyle
 * @date 2021/12/7
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserUpdateDto extends BaseUpdateDto {
    @NotNull(message = "用户id不能为空")
    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("用户名字")
    private String userName;

    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("用户真实姓名")
    private String userRealName;

    @ApiModelProperty("用户性别(0-男性，1-女性，2-保密)")
    private Integer userGender;

    @ApiModelProperty("用户年龄")
    private Integer userAge;

    @ApiModelProperty("用户昵称")
    private String userNickName;

    @ApiModelProperty("用户头像url")
    private String userIcon;

    @ApiModelProperty("用户邮箱")
    private String userEmail;

    @ApiModelProperty("用户电话")
    private String userPhone;

    @ApiModelProperty("用户QQ")
    private String userQq;

    @ApiModelProperty("用户微信")
    private String userWechat;

    @ApiModelProperty("用户google")
    private String userGoogle;

    @ApiModelProperty("用户tg")
    private String userTelegram;

    @ApiModelProperty("用户推特")
    private String userTwitter;

    @ApiModelProperty("用户facebook")
    private String userFacebook;

    @ApiModelProperty("用户状态")
    private boolean isStatus;
}
