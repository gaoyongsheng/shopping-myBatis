package com.shopping.demo.cro;

import com.shopping.demo.cro.base.BaseCro;

import java.util.List;

/**
 * @Author Gao
 * @Date 2021/1/29 22:23
 * @Version 1.0
 */
public class PageResult extends BaseCro {

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private int totalSize;
    /**
     * 页码总数
     */
    private int totalPages;

    /**
     * 数据模型
     */
    private List<?> data;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
