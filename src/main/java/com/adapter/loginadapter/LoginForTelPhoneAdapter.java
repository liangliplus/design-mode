package com.adapter.loginadapter;

public class LoginForTelPhoneAdapter implements LoginAdapter {
    @Override
    public boolean support(Object obj) {
        return obj instanceof  LoginForTelPhoneAdapter;
    }

    @Override
    public ResultMsg login(Object[] params, Object adapter) {
        return null;
    }
}
