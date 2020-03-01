package com.observer.pubsub.v2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  该类是一个事件工具类，本身也是一个被观察者，因为通知监听者
 */
public class EventDispatcher {

    //定义一个集合保存 entry ，每个entry 维护了事件对应的监听者集合
    static final CopyOnWriteArrayList<Entry> LISTENER_HUB = new CopyOnWriteArrayList<>();


    //发布事件方法属于发布者
    static public void fireEvent(Event event){
        for (AbstractEventListener listener : getEntry(event.getClass()).listeners) {
            //循环通知注册过这个事件的监听者
            listener.onEvent(event);
        }
    }

    //被观察定义 注册监听方法 //清空监听者方法

    /**
     * 注册事件监听器 原子性注册
     * @param listener
     */
    static public void addEventListener(AbstractEventListener listener){
        //为监听器注册感兴趣的事件
        for (Class<? extends Event> entryType : listener.interest()) {
            getEntry(entryType).listeners.addIfAbsent(listener);
        }
    }

    static public void clear(){
        LISTENER_HUB.clear();
    }


    //根据事件类型 创建或者获取 entry
    static public Entry getEntry(Class<? extends  Event> eventType){
        for (;;){
            for (Entry entry : LISTENER_HUB) {
                if(entry.eventType == eventType){
                    //事件在列表存在，返回对应事件entry
                    return entry;
                }
            }
            Entry entry = new Entry(eventType);
            //存在 返回false ， 不存在添加成功返回true
            //如果存在就下一次循环，因为存在监听者并发注册同一个事件，保证一个事件类型对应一个Entry
            if(LISTENER_HUB.addIfAbsent(entry)){
                return entry;
            }
        }
    }






    //这是一个维护事件和监听器的类
    static private class Entry{
        final Class<? extends Event> eventType;
        final CopyOnWriteArrayList<AbstractEventListener> listeners; //实现原子注册监听者

        public Entry(Class<? extends Event> eventType) {
            this.eventType = eventType;
            this.listeners = new CopyOnWriteArrayList<>();
        }
    }
    static public abstract class AbstractEventListener{
        //定义向EvnetDispatcher注册监听
        public AbstractEventListener() {
            //注册事件
            EventDispatcher.addEventListener(this);
        }

        //定义感兴趣事件列表 return 感兴趣事件列表
        public abstract List<Class<? extends Event>> interest();

        //定义事件达到如何处理事件
        public abstract  void onEvent(Event event);

    }

    public interface Event{}
}
