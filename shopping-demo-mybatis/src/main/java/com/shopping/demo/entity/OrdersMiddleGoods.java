package com.shopping.demo.entity;

import com.shopping.demo.entity.base.BaseModel;
import lombok.Data;

/**
 * @Author Gao
 * @Date 2021/2/11 23:56
 * @Version 1.0
 */

@Data
public class OrdersMiddleGoods extends BaseModel<OrdersMiddleGoods> {

    private Long midOrdersId;

    private Long midGoodsId;

    public OrdersMiddleGoods(){}

    public OrdersMiddleGoods(Long midOrdersId, Long midGoodsId) {
        this.midOrdersId = midOrdersId;
        this.midGoodsId = midGoodsId;
    }

    @Override
    public Object toDto() {
        return null;
    }
}
