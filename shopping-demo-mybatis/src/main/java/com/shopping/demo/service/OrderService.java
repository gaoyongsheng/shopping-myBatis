package com.shopping.demo.service;

import com.shopping.demo.cro.OrderCreateCro;
import com.shopping.demo.cro.OrderPageConditionCro;
import com.shopping.demo.cro.OrderPageCro;
import com.shopping.demo.entity.Order;
import org.springframework.data.domain.Page;

/**
 * @Author ldc
 * @Date 2020/12/10 15:37
 * @Version 1.0
 */
public interface OrderService {

    Order createOrder(OrderCreateCro orderCreateCro);

    Order findOrderById(Long id);

    Page<Order> findAllOrders(OrderPageCro orderPageCro);

    void deleteOrder(Long id);

    Page<Order> findAllWitnCondition(OrderPageConditionCro orderPageConditionCro);

}
