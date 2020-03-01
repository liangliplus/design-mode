package com.decorate.v2coffee;

/**
 * 浓缩咖啡
 */
public class Espresso implements Coffee{

    @Override
    public String getName() {
        return "浓缩";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
