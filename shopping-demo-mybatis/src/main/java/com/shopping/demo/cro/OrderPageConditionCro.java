package com.shopping.demo.cro;

import com.shopping.demo.cro.base.BaseCro;
import lombok.Data;


@Data
public class OrderPageConditionCro extends BaseCro {

    // 当前第几页。从0开始
    private int offset;
    // 每页的数量
    private int pageSize;

    private String orderStatus;

    private String beginTime;

    private String endTime;


}
