package pers.cgglyle.base.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
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
    @TableId(type = IdType.AUTO)
    @TableField("id")
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Date updateTime;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseVo baseVo = (BaseVo) o;
        return isStatus == baseVo.isStatus && isDeleted == baseVo.isDeleted && isSystem == baseVo.isSystem && Objects.equals(id, baseVo.id) && Objects.equals(createTime, baseVo.createTime) && Objects.equals(updateTime, baseVo.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, updateTime, isStatus, isDeleted, isSystem);
    }
}
