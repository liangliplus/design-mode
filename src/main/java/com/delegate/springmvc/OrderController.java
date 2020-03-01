package com.delegate.springmvc;

import java.util.HashMap;
import java.util.Map;

public class OrderController {
    public Map<String,Object> getOrderbyId(Integer orderId){
        System.out.println("获取订单信息");
        return new HashMap<>();
    }
}
