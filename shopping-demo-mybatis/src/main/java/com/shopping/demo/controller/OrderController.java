package com.shopping.demo.controller;

import com.shopping.demo.cro.OrderCro;
import com.shopping.demo.cro.PageRequest;
import com.shopping.demo.exception.MyShopException;
import com.shopping.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ldc
 * @Date 2020/12/10 15:38
 * @Version 1.0
 */

@RestController
@RequestMapping("/service/v1")
public class OrderController extends AbstractBaseCtrl {

    @Autowired
    OrdersService orderService;

    @PostMapping("/orders.create")
    public Object createOrders(@RequestBody OrderCro orderCreateCro){
        try{
            orderService.insertOrders(orderCreateCro);
            return success("");
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }

    }

    @PostMapping("/order.findAll")
    public Object findOrdersAll(@RequestBody PageRequest pageQuery){
        return success(orderService.findAllGoods(pageQuery));
    }


}
