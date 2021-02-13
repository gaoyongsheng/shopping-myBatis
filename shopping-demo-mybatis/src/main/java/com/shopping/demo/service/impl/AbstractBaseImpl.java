package com.shopping.demo.service.impl;

import com.github.pagehelper.PageInfo;
import com.shopping.demo.cro.PageRequest;
import com.shopping.demo.cro.PageResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractBaseImpl {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize((int) pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setData(pageInfo.getList());
        return pageResult;
    }
    
    /**
     * @Author ldc
     * @Description //TODO 
     * @Date 16:58 2020/12/7
     * @Param [str]
     * @return java.lang.Long
     */
    public Long strToLong(String str){return Long.parseLong(str);}


    /**
     * @Author ldc
     * @Description //TODO 生成当前请求的订单号
     * @Date 14:29 2020/12/14
     * @Param []
     * @return java.lang.String
     */
    public String getCurOrderCode(){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmSS");
        return ft.format(dNow);
    }


}
