package com.shopping.demo.dto;

import com.shopping.demo.dto.base.BaseDto;
import lombok.Data;

/**
 * @Author ldc
 * @Date 2020/12/10 11:09
 * @Version 1.0
 */

@Data
public class OrderDto extends BaseDto {

    private Long Id;

    private String orderCode;

    private String orderStatus;

    private String orderTotalPrice;

    private String orderAddTime;

    private Long goodsId;

    private Long orderUserId;

    private Long orderAddressId;




}
