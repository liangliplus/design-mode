package com.observer.pubsub.impl;

import com.observer.pubsub.AbstractEventListener;
import com.observer.pubsub.Event;

import java.util.Collections;
import java.util.List;

public class TestEventListener  extends AbstractEventListener {
    @Override
    public List<Class<? extends Event>> interest() {
        return Collections.singletonList(LocalEvent.class);
    }

    @Override
    public void onEvent(Event event) {
        LocalEvent localEvent = (LocalEvent) event;
        System.out.println("onEvent 收到处理事件 事件为:"+localEvent);
    }
}
