package com.adapter.loginadapter;

public interface LoginForThrid {
    public ResultMsg loginForQQ(String openId);

    public ResultMsg loginForWeChat(String openId);

    /**
     *  手机号码登录
     * @param phoneNum 手机号码
     * @param msgCode 短信验证码
     * @return
     */
    public ResultMsg loginForTelphone(String phoneNum,String msgCode);
}
