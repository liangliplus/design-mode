package com.observer.simple;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {
    @Subscribe
    public void event(String msg){
        System.out.println("执行subscribe 方法 传入参数"+msg);
    }

}
