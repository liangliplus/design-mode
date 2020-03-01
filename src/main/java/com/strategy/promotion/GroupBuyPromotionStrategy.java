package com.strategy.promotion;

import javax.sound.midi.Soundbank;

public class GroupBuyPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromition() {
        System.out.println("拼团购买 ，10人成团.");
    }
}
