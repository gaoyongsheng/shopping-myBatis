package com.shopping.demo.repository;

import com.shopping.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @Author ldc
 * @Date 2020/12/10 15:28
 * @Version 1.0
 */
public interface OrderRepository extends JpaRepository<Order,Long>, JpaSpecificationExecutor {

    Order findOrderById(Long id);

}
