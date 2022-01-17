package pers.cgglyle.common.response;


import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 分页返回模型。
 *
 * @author cgglyle
 * @date 2021/12/6
 */
public class PageResult {
    @Schema(description = "当前页码")
    private long pageNum;

    @Schema(description = "每页记录数")
    private long pageSize;

    @Schema(description = "总记录数")
    private long totalSize;

    @Schema(description = "总页码")
    private long totalPage;

    @Schema(description = "列表数据")
    private List<?> data;

    public PageResult() {
    }

    public PageResult(long pageNum, long pageSize, long totalSize, long totalPage, List<?> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.totalPage = totalPage;
        this.data = data;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
