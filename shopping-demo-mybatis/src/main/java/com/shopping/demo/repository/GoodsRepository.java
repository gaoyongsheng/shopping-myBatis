package com.shopping.demo.repository;

import com.shopping.demo.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ldc
 * @Date 2020/12/7 16:31
 * @Version 1.0
 */
public interface GoodsRepository extends JpaRepository<Goods,Long> {

    Goods findGoodsById(Long id);

}
