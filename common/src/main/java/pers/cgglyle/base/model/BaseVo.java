package pers.cgglyle.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 基础返回实体。
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@ApiModel("基础返回实体")
public class BaseVo {
    @ApiModelProperty("主键id")
    private Integer id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("状态值('0'=>禁用，'1'=>启用)")
    private boolean isStatus;

    @ApiModelProperty("逻辑删除值('0'=>删除，'1'=>未删除)")
    private boolean isDeleted;

    @ApiModelProperty("是否为系统内置(0-不是,1-是)")
    private boolean isSystem;

    @ApiModelProperty("创建者")
    private Integer createUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isSystem() {
        return isSystem;
    }

    public void setSystem(boolean system) {
        isSystem = system;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseVo baseVo = (BaseVo) o;
        return isStatus == baseVo.isStatus && isDeleted == baseVo.isDeleted && isSystem == baseVo.isSystem && Objects.equals(id, baseVo.id) && Objects.equals(createTime, baseVo.createTime) && Objects.equals(updateTime, baseVo.updateTime) && Objects.equals(createUser, baseVo.createUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, updateTime, isStatus, isDeleted, isSystem, createUser);
    }
}
