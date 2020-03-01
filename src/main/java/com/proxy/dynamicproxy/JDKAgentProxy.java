package com.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKAgentProxy  implements InvocationHandler {
    private Object target;
    public  Object getInstance(Object target) throws Exception{
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }

    public void before(){
        System.out.println("提前了解用户需求，筛选保险产品");
    }
    public void after(){
        System.out.println("聊的不错，适合用户,确认就准备购买了");

    }
}
