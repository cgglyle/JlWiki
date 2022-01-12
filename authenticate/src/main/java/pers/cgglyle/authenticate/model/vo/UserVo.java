package pers.cgglyle.authenticate.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import pers.cgglyle.common.base.model.BaseVo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户显示
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserVo extends BaseVo {
    @Schema(description = "用户名字")
    private String userName;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "用户密码更新时间")
    private LocalDateTime userPasswordUpdateTime;

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

    @Schema(description = "用户角色")
    private List<UserRoleVo> userRole;

    @Schema(description = "用户组")
    private List<UserGroupVo> userGroup;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "用户最后登陆时间")
    private LocalDateTime userLoginTime;

    @Schema(description = "用户登陆次数")
    private Integer userLoginNum;

    @Schema(description = "用户登陆ip")
    private String userLoginIp;
}
