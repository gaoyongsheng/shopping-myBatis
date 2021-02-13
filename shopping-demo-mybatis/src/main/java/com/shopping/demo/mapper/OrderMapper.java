package com.shopping.demo.mapper;

import com.shopping.demo.entity.Order;
import com.shopping.demo.entity.OrderUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Gao
 * @Date 2021/2/11 23:22
 * @Version 1.0
 */

@Repository
public interface OrderMapper {

    // 创建订单
    void insertOrder(Order order);

    // 查询订单
    List<OrderUser> getOrders();
}
