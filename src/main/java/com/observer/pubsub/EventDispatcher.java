package com.observer.pubsub;

import javafx.event.EventType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 事件分发器工具类， 其实是一个被监听者
 */
public class EventDispatcher {
    //声明list 保存 Entry  对象 entry 包含 一个事件对应多个监听者
    static final List<Entry> LISTENER_HUB = new ArrayList<>(); //线程不安全的

    //具备注册监听（为监听者设置感兴趣的事件）
    static public void addEventListener(AbstractEventListener listener){
        //为监听所有感兴趣的事件注册
        for (Class<? extends Event> eventType : listener.interest()) {
            //为listner 感兴趣的事件注册监听
            getEntry(eventType).listeners.addIfAbsent(listener);
        }


    }



    //发布一个具体的事件  不然怎么叫被监听者了（发布者）
    static public void fireEvent(Event event){
        for (AbstractEventListener listener : getEntry(event.getClass()).listeners) {
            //循环通知监听者
            listener.onEvent(event);
        }
    }

    //清理
    static public void clear(){
        LISTENER_HUB.clear();
    }

    //获取或者创建entry
    static public Entry getEntry(Class<? extends Event> eventType){

        for(;;){

            for (Entry entry : LISTENER_HUB) {
                //先判断这个entry 是否存在集合中
                if(entry.eventType == eventType){
                    return entry;
                }
            }

            //否则构建一个Entry
            Entry entry = new Entry(eventType);
            LISTENER_HUB.add(entry);
            return entry;
        }

    }


}
