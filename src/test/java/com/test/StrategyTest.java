package com.test;

import com.strategy.pay.Order;
import com.strategy.pay.PayStrategy;
import com.strategy.pay.Payment;
import com.strategy.promotion.*;
import com.strategy.signatrue.Pdf;
import com.strategy.signatrue.PdfStrategyFactory;
import com.strategy.signatrue.User;
import org.junit.Test;

/**
 * 策略模式的测试类
 */
public class StrategyTest {

    @Test
    public void simplePromotionTest(){
        //比如我们6。18 做返现活动
        //双11做抵扣券
        //在实际的应用场景中，根据不同需求做某一种活动，并不会一次执行多种活动
        /*PromotionActivity promotionActivity618 = new PromotionActivity(new CashBackPromotionStrategy());
        promotionActivity618.excute();
        PromotionActivity promotionActivity1111 = new PromotionActivity(new CouponPromotionStrategy());
        promotionActivity1111.excute();
        */
        /**
         * 这样写满足了我们用户的需求了，当业务经过一定时间的积累
         * 促销活动会越来多，程序员就只能加班赶工了。每次上活动都要改代码 ==。==
         * 还需要做重复测试，判断逻辑可能变得越来越复杂。
         * 关于这段逻辑可以用简单工厂和单例去优化 ,简单工厂的缺点违反开闭原则
         */
        String  promotionKey = "cashBack";
        PromotionStrategy promotionStrategy = null;
        if(promotionKey.equals("cashBack")){
            promotionStrategy = new CashBackPromotionStrategy();
        }else if(promotionKey.equals("coupon")) {
            promotionStrategy = new CouponPromotionStrategy();
        }else if(promotionKey.equals("groupby")){
            promotionStrategy = new GroupBuyPromotionStrategy();
        }
        PromotionActivity promotionActivity = new PromotionActivity(promotionStrategy);
        promotionActivity.excute();
    }


    @Test
    public void simpleFactoryStrategyTest(){
        /**
         * 这样修改后，维护成本就变低了，每次添加新活动，不影响原来的活动代码
         */
        PromotionActivity activity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy("CASH"));
        activity.excute();
    }

    @Test
    public void payStrategyTest(){
        //执行流程 把商品添加进购物车，在从购物车下单
        Order order = new Order(1,231111,300);
        //开始支付，选择微信支付、支付宝、银联卡、京
        //每个渠道它支付的具体算法是不一样
        //基本算法固定的
        //这个值是在支付的时候才决定用哪个值
        System.out.println(order.pay("ALI_PAY").toString());

    }


    @Test
    public void pdfStrategyTest(){
        User user = new User("1",new byte[1024]);
        user.generatePdf(PdfStrategyFactory.INTRODUCTION_PDF);

    }
}
