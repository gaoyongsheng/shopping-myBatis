package com.shopping.demo.cro;

import com.shopping.demo.cro.base.BaseCro;
import com.shopping.demo.dto.OrderDto;
import lombok.Data;

/**
 * @Author ldc
 * @Date 2020/12/10 15:24
 * @Version 1.0
 */

@Data
public class OrderCro extends BaseCro {

    private String orderTotalPrice;

    private Long goodsId;

    private Long orderAddressId;

    public OrderDto toDto(){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderTotalPrice(orderTotalPrice);
        orderDto.setOrderAddressId(orderAddressId);
        orderDto.setGoodsId(goodsId);
        return orderDto;
    }


}
