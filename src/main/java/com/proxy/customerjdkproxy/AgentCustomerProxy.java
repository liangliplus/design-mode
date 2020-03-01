package com.proxy.customerjdkproxy;

import java.lang.reflect.Method;

public class AgentCustomerProxy implements  CustomerInvocationHandler {
    private Object o;
    public Object getInstance(Object target){
        this.o = target;
        return CustomerProxy.newProxyInstance(new CustomerClassloader(), this.o.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(o, args);
        after();
        return invoke;
    }

    public void before(){
        System.out.println("我是自定义实现的动态代理,我知道购买保险的需求");

    }

    public void after(){
        System.out.println("合适就可以交钱购买了");


    }
}
