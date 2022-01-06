package pers.cgglyle.common.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 前端基础请求实体
 *
 * @author cgglyle
 * @date 2021/12/6
 */
@ApiModel("请求实体")
public abstract class BaseQuery {
    @ApiModelProperty("当前页")
    private Long pageNum = 1L;
    @ApiModelProperty("当前页条目数")
    private Long pageSize = 20L;

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
