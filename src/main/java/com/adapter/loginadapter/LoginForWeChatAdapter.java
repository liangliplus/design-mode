package com.adapter.loginadapter;

public class LoginForWeChatAdapter implements LoginAdapter {
    @Override
    public boolean support(Object obj) {
        return obj instanceof LoginForWeChatAdapter;
    }

    @Override
    public ResultMsg login(Object[] params, Object adapter) {
        return null;
    }
}
