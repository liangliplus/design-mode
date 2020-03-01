package com.decorate.v1;

public class EggBatterCake extends BatterCake {
    @Override
    public String getName() {
        return super.getName()+ "+加一个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
