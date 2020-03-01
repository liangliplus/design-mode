package com.observer.pubsub.v2;

public class Test {
    public static void main(String[] args) {
        EventDispatcher.addEventListener(new MockListener());
        EventDispatcher.fireEvent(new MockEvent());
    }
}
