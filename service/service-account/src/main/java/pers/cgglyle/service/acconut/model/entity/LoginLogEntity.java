package pers.cgglyle.service.acconut.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 登陆日志(LoginLog)实体类
 *
 * @author cgglyle
 * @since 2021-12-17 10:12:51
 */

@ApiModel("LoginLog实体类")
@TableName("login_log")
public class LoginLogEntity {
        

    /**
     * 主键
     */     
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Integer id;

    /**
     * 登陆用户名
     */     
    @ApiModelProperty("登陆用户名")
    @TableField("login_user_name")
    private String loginUserName;

    /**
     * 登陆时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("登陆时间")
    @TableField("login_time")
    private LocalDateTime loginTime;

    /**
     * 登陆地址
     */     
    @ApiModelProperty("登陆地址")
    @TableField("login_ip")
    private String loginIp;

    /**
     * 登陆状态
     */     
    @ApiModelProperty("登陆状态")
    @TableField("is_status")
    private boolean isStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }
}

