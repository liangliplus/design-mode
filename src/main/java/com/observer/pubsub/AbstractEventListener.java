package com.observer.pubsub;

import java.util.List;

public abstract class AbstractEventListener {

    //构造函数，注册监听


    public AbstractEventListener() {
        //为自己感兴趣的事件注册监听 原子性的注册
        EventDispatcher.addEventListener(this);
    }

    //返回感兴趣事件列表
    public abstract List<Class<? extends Event>>  interest();

    //处理事件的能力
    public abstract void onEvent(Event event);
}
