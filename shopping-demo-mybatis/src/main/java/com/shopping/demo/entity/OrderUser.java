package com.shopping.demo.entity;

import lombok.Data;

/**
 * @Author Gao
 * @Date 2021/2/12 23:49
 * @Version 1.0
 */

@Data
public class OrderUser extends Order {

    private String userName;

    private String goodsName;

}
