package com.strategy.pay;

public class AliPay extends Payment {
    @Override
    public String name() {
        return "支付宝";
    }

    @Override
    public double amount() {
        return 500;
    }
}
