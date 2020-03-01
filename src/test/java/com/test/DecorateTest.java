package com.test;

import com.decorate.v1.BatterCake;
import com.decorate.v1.EggBatterCake;
import com.decorate.v1.SausageBatterCake;
import com.decorate.v2coffee.*;
import org.junit.Test;

public class DecorateTest {

    @Test
    /**
     * 传统的扩展方法 继承的用户，当用户需求为需要加2个鸡蛋或者2个香肠，只能加类，不利于扩展
     */
    public void testV1(){
        BatterCake batterCake = new EggBatterCake();//加一个鸡蛋
        System.out.println(batterCake.getName()+"\t"+batterCake.getPrice());
        batterCake = new SausageBatterCake();
        System.out.println(batterCake.getName()+"\t"+batterCake.getPrice());

    }

    /**
     * 使用装饰者 不引用原有coffee逻辑，在它上面扩展加蜂蜜，牛奶，比继承更灵活，也更扩展
     * 要两份牛奶，两个蜂蜜，分别new 两次就可以了
     * 与静态代理本质区别是 装饰是一种is-a 的关于 coffee不管被装饰多少次还是咖啡
     * 与适配器 区别 前者是has-a，设计理念在于兼容，在设计中后置设置。（成语亡羊补牢）
     * 可以结合策略消费后升级会员进行打折，不同等级的会员就是不同的策略
     */
    @Test
    public void testCoffeeDecorator(){
        Coffee coffee = new Espresso();//来一杯浓缩提提神
        coffee = new MikeDecorator(coffee);//加牛奶
        coffee = new MikeDecorator(coffee);//加牛奶
        coffee = new HoneyDecorator(coffee);//加蜂蜜
        System.out.println(coffee.getName() +"\t" + coffee.getPrice());

        System.out.println("======================");
        //在来一个烘焙
        Coffee coffee2 = new RoastedCoffee();
        coffee2 = new HoneyDecorator(coffee2);
        System.out.println(coffee2.getName() +"\t" + coffee2.getPrice());

    }
}
