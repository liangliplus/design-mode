package com.proxy.jdbcstaticproxy;

import com.proxy.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements  IorderService{
    IorderService iorderService;

    public OrderServiceStaticProxy(IorderService iorderService) {
        this.iorderService = iorderService;
    }

    @Override
    public int insertOrder(Order order) {
        before();
        //根据order创建时间切换到对应的库中
        Date createTime =  order.getCreateTime();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY");//只根据年份分库
        String format = sdf.format(createTime);
        DynamicDataSourceEntity.set("DB_"+format);
        System.out.println("动态切换数据源DB_"+format+"中");
        int i = iorderService.insertOrder(order);
        //使用完成切换默认数据源
        DynamicDataSourceEntity.restore();
        after();
        return i;
    }

    public void before(){
        System.out.println("proxy Method before");
    }

    public void after(){
        System.out.println("proxy Method after");
    }
}
