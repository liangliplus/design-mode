package com.adapter.loginadapter;

/**
 * 稳定的代码不懂，通过组合方法去适配
 */
public class SiginServiceAdapter implements LoginForThrid{
    private SiginService siginService;

    public SiginServiceAdapter(SiginService siginService) {
        this.siginService = siginService;
    }

    @Override
    public ResultMsg loginForQQ(String openId) {
        return processlogin(new String[]{openId},LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWeChat(String openId) {
        return processlogin(new String[]{openId},LoginForWeChatAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String phoneNum, String msgCode) {
        return processlogin(new String[]{phoneNum,msgCode},LoginForTelPhoneAdapter.class);
    }


    private ResultMsg processlogin(Object[] obj,Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter loginAdapter = clazz.newInstance();
            if(loginAdapter.support(loginAdapter)){
                ResultMsg login = loginAdapter.login(obj, loginAdapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
