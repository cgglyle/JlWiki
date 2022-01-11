package pers.cgglyle.common.base.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 基础删除数据模型
 *
 * @author cgglyle
 * @date 2022-01-04 10:11
 */
@Data
@Schema(description = "基础删除模型")
@EqualsAndHashCode(callSuper = true)
public class BaseDeleteDto extends BaseDto {
    @Schema(description = "删除id")
    private Serializable id;
    @Schema(description = "删除id列表")
    private List<Serializable> idList;
}
