package com.decorate.v2coffee;

public class SugarDecorator implements Decorator {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getName() {
        return coffee.getName() +"+糖";
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + 1;
    }
}
