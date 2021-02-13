package com.shopping.demo.entity;

import com.shopping.demo.dto.OrderDto;
import com.shopping.demo.entity.base.BaseModel;
import lombok.Data;

/**
 * @Author ldc
 * @Date 2020/12/10 10:08
 * @Version 1.0
 */

@Data
public class Order extends BaseModel<OrderDto> {

    private Long id;

    private String orderCode;

    private String orderStatus;

    private String orderTotalPrice;

    private String orderAddTime;

    private Long goodsId;

    private Long orderUserId;

    private Long orderAddressId;

    public Order(){}

    public Order(OrderDto orderDto){
        this.id = orderDto.getId();
        this.orderCode = orderDto.getOrderCode();
        this.orderStatus = orderDto.getOrderStatus();
        this.orderTotalPrice = orderDto.getOrderTotalPrice();
        this.orderAddTime = orderDto.getOrderAddTime();
        this.orderUserId = orderDto.getOrderUserId();
        this.orderAddressId = orderDto.getOrderAddressId();
        this.goodsId = orderDto.getGoodsId();
    }



    @Override
    public OrderDto toDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setOrderCode(orderCode);
        orderDto.setOrderStatus(orderStatus);
        orderDto.setOrderTotalPrice(orderTotalPrice);
        orderDto.setOrderAddTime(orderAddTime);
        orderDto.setOrderUserId(orderUserId);
        orderDto.setOrderAddressId(orderAddressId);
        orderDto.setGoodsId(goodsId);
        return orderDto;
    }
}
