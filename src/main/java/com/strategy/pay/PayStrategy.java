package com.strategy.pay;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {
    public static final String ALI_PAY = "AliPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFAULT_PAY = ALI_PAY;


    private static Map<String,Payment> PAYMENT_MAP = new HashMap<>();
    private PayStrategy(){}
    static{
        PAYMENT_MAP.put("ALI_PAY",new AliPay());
        PAYMENT_MAP.put("UNION_PAY",new UnionPay());
        PAYMENT_MAP.put("WECHAT_PAY",new WechatPay());

    }


    public static Payment getPayment(String paymentKey){
        if(!PAYMENT_MAP.containsKey(paymentKey)){
            return PAYMENT_MAP.get(DEFAULT_PAY);
        }
        return PAYMENT_MAP.get(paymentKey);
    }

}
