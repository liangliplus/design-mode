package com.strategy.promotion;

public class CouponPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromition() {
        System.out.println("优惠券活动，抵扣相应面额的商品价格");
    }
}
