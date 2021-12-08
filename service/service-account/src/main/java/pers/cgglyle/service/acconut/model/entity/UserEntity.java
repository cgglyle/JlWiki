package pers.cgglyle.service.acconut.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import pers.cgglyle.base.model.BaseEntity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 用户实体
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@ApiModel("用户实体")
@TableName("user")
public class UserEntity extends BaseEntity {
    @ApiModelProperty("用户名字")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("用户密码")
    @TableField("user_password")
    private String userPassword;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty("用户密码更新时间")
    @TableField("user_password_update_time")
    private LocalDateTime userPasswordUpdateTime;

    @ApiModelProperty("用户真实姓名")
    @TableField("user_real_name")
    private String userRealName;

    @ApiModelProperty("用户性别(0-男性，1-女性，2-保密)")
    @TableField("user_gender")
    private Integer userGender;

    @ApiModelProperty("用户年龄")
    @TableField("user_age")
    private Integer userAge;

    @ApiModelProperty("用户昵称")
    @TableField("user_nick_name")
    private String userNickName;

    @ApiModelProperty("用户头像url")
    @TableField("user_icon")
    private String userIcon;

    @ApiModelProperty("用户邮箱")
    @TableField("user_email")
    private String userEmail;

    @ApiModelProperty("用户电话")
    @TableField("user_phone")
    private String userPhone;

    @ApiModelProperty("用户QQ")
    @TableField("user_qq")
    private String userQq;

    @ApiModelProperty("用户微信")
    @TableField("user_wechat")
    private String userWechat;

    @ApiModelProperty("用户google")
    @TableField("user_google")
    private String userGoogle;

    @ApiModelProperty("用户tg")
    @TableField("user_telegram")
    private String userTelegram;

    @ApiModelProperty("用户推特")
    @TableField("user_twitter")
    private String userTwitter;

    @ApiModelProperty("用户facebook")
    @TableField("user_facebook")
    private String userFacebook;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty("用户最后登陆时间")
    @TableField("user_login_time")
    private LocalDateTime userLoginTime;

    @ApiModelProperty("用户登陆次数")
    @TableField("user_login_num")
    private Integer userLoginNum;

    @ApiModelProperty("用户登陆ip")
    @TableField("user_login_ip")
    private String userLoginIp;

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

    public LocalDateTime getUserPasswordUpdateTime() {
        return userPasswordUpdateTime;
    }

    public void setUserPasswordUpdateTime(LocalDateTime userPasswordUpdateTime) {
        this.userPasswordUpdateTime = userPasswordUpdateTime;
    }

    public LocalDateTime getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(LocalDateTime userLoginTime) {
        this.userLoginTime = userLoginTime;
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

    public Integer getUserLoginNum() {
        return userLoginNum;
    }

    public void setUserLoginNum(Integer userLoginNum) {
        this.userLoginNum = userLoginNum;
    }

    public String getUserLoginIp() {
        return userLoginIp;
    }

    public void setUserLoginIp(String userLoginIp) {
        this.userLoginIp = userLoginIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userName, that.userName) && Objects.equals(userPassword, that.userPassword) && Objects.equals(userPasswordUpdateTime, that.userPasswordUpdateTime) && Objects.equals(userRealName, that.userRealName) && Objects.equals(userGender, that.userGender) && Objects.equals(userAge, that.userAge) && Objects.equals(userNickName, that.userNickName) && Objects.equals(userIcon, that.userIcon) && Objects.equals(userEmail, that.userEmail) && Objects.equals(userPhone, that.userPhone) && Objects.equals(userQq, that.userQq) && Objects.equals(userWechat, that.userWechat) && Objects.equals(userGoogle, that.userGoogle) && Objects.equals(userTelegram, that.userTelegram) && Objects.equals(userTwitter, that.userTwitter) && Objects.equals(userFacebook, that.userFacebook) && Objects.equals(userLoginTime, that.userLoginTime) && Objects.equals(userLoginNum, that.userLoginNum) && Objects.equals(userLoginIp, that.userLoginIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userName, userPassword, userPasswordUpdateTime, userRealName, userGender, userAge, userNickName, userIcon, userEmail, userPhone, userQq, userWechat, userGoogle, userTelegram, userTwitter, userFacebook, userLoginTime, userLoginNum, userLoginIp);
    }
}
