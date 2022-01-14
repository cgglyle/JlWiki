package pers.cgglyle.common.base.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 基础返回实体。
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Data
@Schema(description = "基础显示模型")
public abstract class BaseVo {
    @Schema(description = "主键id")
    private Integer id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "状态值('0'=>禁用，'1'=>启用)")
    private boolean isStatus;

    @Schema(description = "逻辑删除值('0'=>删除，'1'=>未删除)")
    private boolean isDeleted;

    @Schema(description = "是否为系统内置(0-不是,1-是)")
    private boolean isSystem;

    @Schema(description = "创建者")
    private Integer createUser;
}
