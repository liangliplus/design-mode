package com.decorate.v2coffee;

/**
 * 装饰器的抽象 ，也可以不要装饰器的抽象
 */
public interface Decorator extends Coffee {
    @Override
    String getName();

    @Override
    int getPrice();
}
