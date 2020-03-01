package com.proxy.jdbcstaticproxy;

import com.proxy.Order;

/**
 * 订单dao
 */
public class OrderDao {
    int insert(Order order){
        System.out.println("创建订单成功");
        return 1;
    }
}
