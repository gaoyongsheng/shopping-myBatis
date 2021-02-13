package com.shopping.demo.mapper;

import com.shopping.demo.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Gao
 * @Date 2021/2/4 23:05
 * @Version 1.0
 */
@Repository
public interface GoodsMapper {

    // 新增单个商品
    Long insertGoods(Goods goods);

    // 批量新增商品
    void insertGoodsList(List<Goods> goodsList);

    // 查找商品通过商品ID
    Goods getGoodsById(Long id);

    // 分页查找所有商品
    List<Goods> getGoods();

    // 分页查找某个用户上传的所有商品
    List<Goods> getGoodsByUserId(Long userId);

    // 修改商品
    void updateGoods(Goods goods);

    // 删除商品通过商品Id
    void deleteGoodsById(Long id);

    // 批量删除商品
    void deleteGoodsList(List<Long> idList);
}
