package com.shopping.demo.service.impl;

import com.shopping.demo.constants.ShopExceptionCode;
import com.shopping.demo.cro.OrderCreateCro;
import com.shopping.demo.cro.OrderPageConditionCro;
import com.shopping.demo.cro.OrderPageCro;
import com.shopping.demo.entity.*;
import com.shopping.demo.exception.MyShopException;
import com.shopping.demo.repository.OrderRepository;
import com.shopping.demo.service.AddressService;
import com.shopping.demo.service.GoodsService;
import com.shopping.demo.service.OrderService;
import com.shopping.demo.service.ShopCartService;
import com.shopping.demo.utils.DateTimeUtils;
import com.shopping.demo.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ldc
 * @Date 2020/12/10 15:37
 * @Version 1.0
 */

@Service
@Transactional
public class OrderServiceImpl extends AbstractBaseImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    GoodsService goodsService;

    @Autowired
    ShopCartService shopCartService;

    @Autowired
    AddressService addressService;

    @Override
    public Order createOrder(OrderCreateCro orderCreateCro) {
        Order order = new Order();

        ShopCart shopCart = new ShopCart();
        shopCart.setCount(orderCreateCro.getCount());
        shopCart.setTotalPrice(orderCreateCro.getPrice());

        Set<Goods> goodsList = new HashSet<Goods>();
        Goods curGoods = goodsService.findGoodsById(orderCreateCro.getGoodsId());
        goodsList.add(curGoods);
        shopCart.setGoodsList(goodsList);

        ShopCart temp = shopCartService.createShopCart(shopCart);

        Set<ShopCart> shopCartList = new HashSet<ShopCart>();
        shopCartList.add(temp);
        order.setShopCartList(shopCartList);

        order.setOrderCode(getCurOrderCode());
        order.setOrderAddTime(DateTimeUtils.getSysCurDate());
        order.setOrderTotalPrice(orderCreateCro.getPrice());
        order.setOrderStatus(0+"");

        User curUser = (User) ThreadLocalUtils.get();
        order.setUser(curUser);

        Address addr = addressService.findAddressById(strToLong(orderCreateCro.getAddressId()));
        order.setAddress(addr);

        return orderRepository.save(order);
    }

    @Override
    public Order findOrderById(Long id) {
        Order order = orderRepository.findOrderById(id);
        if(null == order){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"订单不存在");
        }
        return orderRepository.findOrderById(id);
    }

    @Override
    public Page<Order> findAllOrders(OrderPageCro orderPageCro) {

        Sort sort = Sort.by("orderAddTime").descending();
        Pageable pageable = getPageable(orderPageCro.getOffset(),orderPageCro.getPageSize(),sort);

        return orderRepository.findAll(pageable);
    }

    @Override
    public void deleteOrder(Long id) {
        findOrderById(id);

        orderRepository.deleteById(id);
    }

    @Override
    public Page<Order> findAllWitnCondition(OrderPageConditionCro orderPageConditionCro) {

        Pageable pageable = getPageable(orderPageConditionCro.getOffset(),orderPageConditionCro.getPageSize());

        Page<Order> orderPage = orderRepository.findAll(new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> list = new ArrayList<Predicate>();
                // 条件查询订单状态 orderStatus
                if(orderPageConditionCro.getOrderStatus() != ""){
                    Predicate statusP = criteriaBuilder.equal(root.get("orderStatus"),orderPageConditionCro.getOrderStatus());
                    list.add(statusP);
                }
                // 时间范围查询 orderAddTime
                if(orderPageConditionCro.getBeginTime() != "" && orderPageConditionCro.getEndTime() != ""){
                    Predicate timeRange = criteriaBuilder.between(root.get("orderAddTime"),orderPageConditionCro.getBeginTime(),
                            orderPageConditionCro.getEndTime());
                    list.add(timeRange);
                }

                Predicate[] p = new Predicate[list.size()];

                return criteriaBuilder.and(list.toArray(p));
            }
        }, pageable);

        return orderPage;
    }

}
