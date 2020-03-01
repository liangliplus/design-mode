package com.observer.pubsub.v2;

import java.util.Collections;
import java.util.List;
import com.observer.pubsub.v2.EventDispatcher.AbstractEventListener;
import com.observer.pubsub.v2.EventDispatcher.Event;

public class MockListener extends AbstractEventListener {
    @Override
    public List<Class<? extends Event>> interest() {
        return Collections.singletonList(MockEvent.class);
    }

    @Override
    public void onEvent(Event event) {
        System.out.println("mockListener 接受到来自发布者发布的事件："+event);
    }


}
class MockEvent implements Event{

}


