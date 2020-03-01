package com.observer.pubsub;

import com.observer.pubsub.impl.LocalEvent;
import com.observer.pubsub.impl.TestEventListener;

public class PubSubTest {
    public static void main(String[] args) {
        //注册监听了
        EventDispatcher.addEventListener(new TestEventListener());
        EventDispatcher.fireEvent(new LocalEvent());

    }
}
