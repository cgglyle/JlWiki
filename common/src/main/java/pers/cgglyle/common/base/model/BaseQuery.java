package pers.cgglyle.common.base.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 前端基础请求实体
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@Data
@Schema(description = "基础请求模型")
public abstract class BaseQuery {
    @Schema(description = "当前页")
    private Long pageNum = 1L;
    @Schema(description = "当前页条目数")
    private Long pageSize = 20L;
}
