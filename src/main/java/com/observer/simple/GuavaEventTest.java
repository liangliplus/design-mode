package com.observer.simple;

import com.google.common.eventbus.EventBus;

public class GuavaEventTest {
    public static void main(String[] args) {
            EventBus eventBus = new EventBus();
            eventBus.register(new GuavaEvent());
            eventBus.post("kenneth");


        //使用注解开发，简化配置
        //从我们的struts 基于类  spring基于方法

        //jdk观察者基于类  被监视对象需要继承Observable 监视对象需要实现Observer
        //Guava 基于方法




    }

}
