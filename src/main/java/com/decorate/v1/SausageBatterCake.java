package com.decorate.v1;

public class SausageBatterCake extends EggBatterCake {
    @Override
    public String getName() {
        return super.getName() +"加一个香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+2;
    }
}
