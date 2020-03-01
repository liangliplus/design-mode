package com.adapter.loginadapter;

import org.springframework.web.servlet.HandlerAdapter;

public class LoginForQQAdapter implements LoginAdapter{


    @Override
    public boolean support(Object obj) {
        return obj instanceof  LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(Object[] params, Object adapter) {
        return null;
    }

}
