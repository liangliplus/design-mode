package com.strategy.promotion;

public class CashBackPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromition() {
        System.out.println("返现促销，返现到支付宝余额");
    }
}
