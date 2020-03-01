package com.decorate.v2coffee;

public class MikeDecorator implements Decorator {
    private Coffee coffee;//持有一个被装饰的抽象，与单例模式有点相似，但是职责不同，一个增强，一个扩展

    public MikeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getName() {
        return coffee.getName() + "+牛奶";
    }

    @Override
    public int getPrice() {
        return coffee.getPrice() + 3;
    }
}
