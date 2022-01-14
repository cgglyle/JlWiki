package pers.cgglyle.common.base.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 基础实体类。
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Data
@Schema(description = "基础实体类")
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3683323499263018529L;

    @Schema(description = "主键id")
    @TableId(type = IdType.AUTO)
    private Integer id;

}
