package com.strategy.promotion;

/*
 * 促销活动类
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void excute(){
        promotionStrategy.doPromition();
    }

}
