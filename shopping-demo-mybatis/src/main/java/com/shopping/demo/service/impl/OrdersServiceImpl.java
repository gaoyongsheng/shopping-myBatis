package com.shopping.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.demo.cro.OrderCro;
import com.shopping.demo.cro.PageRequest;
import com.shopping.demo.cro.PageResult;
import com.shopping.demo.dto.OrderDto;
import com.shopping.demo.entity.*;
import com.shopping.demo.mapper.OrderMapper;
import com.shopping.demo.mapper.OrdersMiddleGoodsMapper;
import com.shopping.demo.service.OrdersService;
import com.shopping.demo.utils.DateTimeUtils;
import com.shopping.demo.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl extends AbstractBaseImpl implements OrdersService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrdersMiddleGoodsMapper ordersMiddleGoodsMapper;

    @Override
    public void insertOrders(OrderCro orderCro) {
        OrderDto orderDto = orderCro.toDto();
        Order order = new Order(orderDto);

        order.setOrderCode(getCurOrderCode());
        order.setOrderAddTime(DateTimeUtils.getSysCurDate());
        order.setOrderStatus(0+"");
        User curUser = (User) ThreadLocalUtils.get();
        order.setOrderUserId(curUser.getId());

        orderMapper.insertOrder(order);

        OrdersMiddleGoods ordersMiddleGoods = new OrdersMiddleGoods(order.getId(),order.getGoodsId());
        ordersMiddleGoodsMapper.insertMiddle(ordersMiddleGoods);
    }

    @Override
    public PageResult findAllGoods(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<OrderUser> orderList = orderMapper.getOrders();
        return getPageResult(pageRequest,new PageInfo<OrderUser>(orderList));
    }
}
