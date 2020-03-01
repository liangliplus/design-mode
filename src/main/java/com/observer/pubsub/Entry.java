package com.observer.pubsub;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Entry {
    final Class<? extends Event> eventType;
    CopyOnWriteArrayList<AbstractEventListener> listeners; //对该事件感兴趣的所有监听者

    public Entry(Class<? extends Event> eventType) {
        this.eventType = eventType;
        listeners = new CopyOnWriteArrayList<>();
    }
}
