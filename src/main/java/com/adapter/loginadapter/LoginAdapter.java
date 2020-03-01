package com.adapter.loginadapter;

public interface LoginAdapter {
    public boolean support(Object obj);
    public ResultMsg login(Object[] params,Object adapter);


}
