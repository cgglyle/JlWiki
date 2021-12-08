package pers.cgglyle.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

/**
 * 分页返回模型。
 *
 * @author cgglyle
 * @date 2021/12/6
 */
public class PageResult {
    @ApiModelProperty(value = "当前页码")
    private long pageNum;

    @ApiModelProperty(value = "每页记录数")
    private long pageSize;

    @ApiModelProperty(value = "总记录数")
    private long totalSize;

    @ApiModelProperty(value = "总页码")
    private long totalPage;

    @ApiModelProperty(value = "列表数据")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageResult that = (PageResult) o;
        return pageNum == that.pageNum && pageSize == that.pageSize && totalSize == that.totalSize && totalPage == that.totalPage && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNum, pageSize, totalSize, totalPage, data);
    }
}
