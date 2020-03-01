package com.strategy.pay;

public class WechatPay extends Payment {
    @Override
    public String name() {
        return "微信支付";
    }

    @Override
    public double amount() {
        return 300;
    }
}
