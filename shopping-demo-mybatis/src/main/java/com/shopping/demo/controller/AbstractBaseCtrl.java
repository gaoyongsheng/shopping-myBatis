package com.shopping.demo.controller;

import com.shopping.demo.utils.ResponseUtils;

public class AbstractBaseCtrl {

    /**
     * 返回正确的处理数据
     * */
    public Object success(Object data){
        return ResponseUtils.success(data);
    }

    /**
     * 返回错误的处理数据
     * */
    public Object failure(String code,String msg){ return ResponseUtils.failure(code,msg); }


}
