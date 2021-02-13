package com.shopping.demo.service;

import com.shopping.demo.cro.OrderCro;
import com.shopping.demo.cro.PageRequest;
import com.shopping.demo.cro.PageResult;

/**
 * @Author Gao
 * @Date 2021/2/12 0:28
 * @Version 1.0
 */
public interface OrdersService {

    // 创建订单
    void insertOrders(OrderCro orderCro);

    // 分页查询
    PageResult findAllGoods(PageRequest pageRequest);

}
