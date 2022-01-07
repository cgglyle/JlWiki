package pers.cgglyle.service.account.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("用户名字")
    private String userName;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("用户密码更新时间")
    private LocalDateTime userPasswordUpdateTime;

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

    @ApiModelProperty("用户角色")
    private List<UserRoleVo> userRole;

    @ApiModelProperty("用户组")
    private List<UserGroupVo> userGroup;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("用户最后登陆时间")
    private LocalDateTime userLoginTime;

    @ApiModelProperty("用户登陆次数")
    private Integer userLoginNum;

    @ApiModelProperty("用户登陆ip")
    private String userLoginIp;
}
