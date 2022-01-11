package pers.cgglyle.authenticate.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "主键id")
    private String id;

    @Schema(description = "用户名字")
    private String userName;

    @Schema(description = "用户密码")
    private String userPassword;

    @Schema(description = "用户真实姓名")
    private String userRealName;

    @Schema(description = "(0-男性，1-女性，2-保密)")
    private Integer userGender;

    @Schema(description = "用户年龄")
    private Integer userAge;

    @Schema(description = "用户昵称")
    private String userNickName;

    @Schema(description = "用户头像url")
    private String userIcon;

    @Schema(description = "用户邮箱")
    private String userEmail;

    @Schema(description = "用户电话")
    private String userPhone;

    @Schema(description = "用户QQ")
    private String userQq;

    @Schema(description = "用户微信")
    private String userWechat;

    @Schema(description = "用户google")
    private String userGoogle;

    @Schema(description = "用户tg")
    private String userTelegram;

    @Schema(description = "用户推特")
    private String userTwitter;

    @Schema(description = "用户facebook")
    private String userFacebook;

    @Schema(description = "用户状态")
    private boolean isStatus;
}
