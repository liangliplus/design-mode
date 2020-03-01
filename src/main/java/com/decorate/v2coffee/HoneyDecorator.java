package com.decorate.v2coffee;

public class HoneyDecorator implements Decorator {
    private Coffee coffee;

    public HoneyDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getName() {
        return coffee.getName() +"+蜂蜜";
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + 2;
    }
}
