package pers.cgglyle.authenticate.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import pers.cgglyle.common.base.model.BaseEntity;

import java.time.LocalDateTime;

/**
 * 用户实体
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Schema(description = "用户实体")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class UserEntity extends BaseEntity {
    @Schema(description = "用户名字")
    @TableField("user_name")
    private String userName;

    @Schema(description = "用户密码")
    @TableField("user_password")
    private String userPassword;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "用户密码更新时间")
    @TableField("user_password_update_time")
    private LocalDateTime userPasswordUpdateTime;

    @Schema(description = "用户真实姓名")
    @TableField("user_real_name")
    private String userRealName;

    @Schema(description = "(0-男性，1-女性，2-保密)")
    @TableField("user_gender")
    private Integer userGender;

    @Schema(description = "用户年龄")
    @TableField("user_age")
    private Integer userAge;

    @Schema(description = "用户昵称")
    @TableField("user_nick_name")
    private String userNickName;

    @Schema(description = "用户头像url")
    @TableField("user_icon")
    private String userIcon;

    @Schema(description = "用户邮箱")
    @TableField("user_email")
    private String userEmail;

    @Schema(description = "用户电话")
    @TableField("user_phone")
    private String userPhone;

    @Schema(description = "用户QQ")
    @TableField("user_qq")
    private String userQq;

    @Schema(description = "用户微信")
    @TableField("user_wechat")
    private String userWechat;

    @Schema(description = "用户google")
    @TableField("user_google")
    private String userGoogle;

    @Schema(description = "用户tg")
    @TableField("user_telegram")
    private String userTelegram;

    @Schema(description = "用户推特")
    @TableField("user_twitter")
    private String userTwitter;

    @Schema(description = "用户facebook")
    @TableField("user_facebook")
    private String userFacebook;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "用户最后登陆时间")
    @TableField("user_login_time")
    private LocalDateTime userLoginTime;

    @Schema(description = "用户登陆次数")
    @TableField("user_login_num")
    private Integer userLoginNum;

    @Schema(description = "用户登陆ip")
    @TableField("user_login_ip")
    private String userLoginIp;

}
