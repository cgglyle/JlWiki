package pers.cgglyle.service.acconut.model.dto;

import io.swagger.annotations.ApiModelProperty;
import pers.cgglyle.common.base.model.BaseDto;

import java.util.Objects;

/**
 * 用户添加数据模型
 *
 * @author cgglyle
 * @date 2021/12/7
 */
public class UserAddDto extends BaseDto {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public String getUserGoogle() {
        return userGoogle;
    }

    public void setUserGoogle(String userGoogle) {
        this.userGoogle = userGoogle;
    }

    public String getUserTelegram() {
        return userTelegram;
    }

    public void setUserTelegram(String userTelegram) {
        this.userTelegram = userTelegram;
    }

    public String getUserTwitter() {
        return userTwitter;
    }

    public void setUserTwitter(String userTwitter) {
        this.userTwitter = userTwitter;
    }

    public String getUserFacebook() {
        return userFacebook;
    }

    public void setUserFacebook(String userFacebook) {
        this.userFacebook = userFacebook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserAddDto that = (UserAddDto) o;
        return Objects.equals(userName, that.userName) && Objects.equals(userPassword, that.userPassword) && Objects.equals(userRealName, that.userRealName) && Objects.equals(userGender, that.userGender) && Objects.equals(userAge, that.userAge) && Objects.equals(userNickName, that.userNickName) && Objects.equals(userIcon, that.userIcon) && Objects.equals(userEmail, that.userEmail) && Objects.equals(userPhone, that.userPhone) && Objects.equals(userQq, that.userQq) && Objects.equals(userWechat, that.userWechat) && Objects.equals(userGoogle, that.userGoogle) && Objects.equals(userTelegram, that.userTelegram) && Objects.equals(userTwitter, that.userTwitter) && Objects.equals(userFacebook, that.userFacebook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userName, userPassword, userRealName, userGender, userAge, userNickName, userIcon, userEmail, userPhone, userQq, userWechat, userGoogle, userTelegram, userTwitter, userFacebook);
    }
}
