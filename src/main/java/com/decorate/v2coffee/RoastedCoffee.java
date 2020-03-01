package com.decorate.v2coffee;

/**
 * 烘焙咖啡
 */
public class RoastedCoffee implements Coffee{

    @Override
    public String getName() {
        return "烘培";
    }

    @Override
    public int getPrice() {
        return 6;
    }
}
