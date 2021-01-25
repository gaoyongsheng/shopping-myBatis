package com.shopping.demo.repository;

import com.shopping.demo.entity.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ldc
 * @Date 2020/12/15 10:07
 * @Version 1.0
 */
public interface ShopCartRepository extends JpaRepository<ShopCart,Long> {


}
