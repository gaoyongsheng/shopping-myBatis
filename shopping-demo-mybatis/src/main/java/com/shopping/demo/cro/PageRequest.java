package com.shopping.demo.cro;

import com.shopping.demo.cro.base.BaseCro;

/**
 * @Author Gao
 * @Date 2021/1/29 22:21
 * @Version 1.0
 */
public class PageRequest extends BaseCro {

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

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
}
