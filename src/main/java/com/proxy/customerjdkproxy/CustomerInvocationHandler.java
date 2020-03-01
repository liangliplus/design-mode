package com.proxy.customerjdkproxy;

import java.lang.reflect.Method;

public interface CustomerInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
