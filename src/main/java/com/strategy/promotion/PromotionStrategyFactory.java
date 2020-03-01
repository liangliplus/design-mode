package com.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例的简单工厂模式 饿汉式
 */
public class PromotionStrategyFactory {
    private static Map<String,PromotionStrategy> PROMOTION_KEY_MAP = new HashMap<>();
    static{
        PROMOTION_KEY_MAP.put(PromotionKey.cash,new CashBackPromotionStrategy());
        PROMOTION_KEY_MAP.put(PromotionKey.groupBuy,new GroupBuyPromotionStrategy());
        PROMOTION_KEY_MAP.put(PromotionKey.coupon,new CouponPromotionStrategy());
    }


    private static final PromotionStrategy NOT_EMPTY = new NotEmptyPromotion();

    /**
     * 全局访问点
     * @param promotionKey
     * @return
     */
    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_KEY_MAP.get(promotionKey);
        return promotionStrategy == null ? NOT_EMPTY : promotionStrategy;
    }
    private interface PromotionKey{
         String cash = "CASH";
         String groupBuy = "GROUPBUY";
         String coupon = "COUPON";
    }




}
