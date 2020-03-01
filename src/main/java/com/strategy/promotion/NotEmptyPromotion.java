package com.strategy.promotion;

public class NotEmptyPromotion implements PromotionStrategy{
    @Override
    public void doPromition() {
        System.out.println("没有活动啊 ==========");
    }
}
