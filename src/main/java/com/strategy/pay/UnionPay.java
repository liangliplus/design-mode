package com.strategy.pay;

public class UnionPay extends Payment {
    @Override
    public String name() {
        return "银联";
    }

    @Override
    public double amount() {
        return 150;
    }
}
