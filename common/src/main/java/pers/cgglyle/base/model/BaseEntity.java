package pers.cgglyle.base.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 基础实体类。
 *
 * @author cgglyle
 * @date 2021/12/6
 */
public class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3683323499263018529L;

    @ApiModelProperty("主键id")
    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Integer id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("状态值('0'=>禁用，'1'=>启用)")
    @TableField("is_status")
    private boolean isStatus;

    @ApiModelProperty("逻辑删除值('0'=>删除，'1'=>未删除)")
    @TableField("is_deleted")
    @TableLogic(value = "true", delval = "false")
    private boolean isDeleted;

    @ApiModelProperty("是否为系统内置(0-不是,1-是)")
    @TableField("is_system")
    private boolean isSystem;

    @ApiModelProperty("创建用户")
    @TableField("create_user")
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
        BaseEntity baseEntity = (BaseEntity) o;
        return isStatus == baseEntity.isStatus && isDeleted == baseEntity.isDeleted && isSystem == baseEntity.isSystem && Objects.equals(id, baseEntity.id) && Objects.equals(createTime, baseEntity.createTime) && Objects.equals(updateTime, baseEntity.updateTime) && Objects.equals(createUser, baseEntity.createUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, updateTime, isStatus, isDeleted, isSystem, createUser);
    }
}
