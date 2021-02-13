package com.shopping.demo.mapper;

import com.shopping.demo.entity.Order;
import com.shopping.demo.entity.OrdersMiddleGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Gao
 * @Date 2021/2/11 23:49
 * @Version 1.0
 */
@Repository
public interface OrdersMiddleGoodsMapper {

    // 创建
    void insertMiddle(OrdersMiddleGoods ordersMiddleGoods);

    // 查询
    List<Order> getMiddle();

}
