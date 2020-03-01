package com.proxy.jdbcstaticproxy;

import com.proxy.Order;

public class OrderServiceImpl implements IorderService{
    private OrderDao orderDao;

    //模拟spring 构造注入
    public OrderServiceImpl() {
        this.orderDao = new OrderDao();
    }

    @Override
    public int insertOrder(Order order) {
        System.out.println("OrderServiceImpl 创建订单");
        return orderDao.insert(order);
    }
}
