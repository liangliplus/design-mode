package com.strategy.pay;

/***
 * 支付方式
 */
public abstract class Payment {
    public abstract String name();
    public abstract  double amount();//账户余额


    public PayState pay(String uid,double amount){
        if(amount() < amount){
            return new PayState(500,"支付失败","本次支付金额 ："+amount);
        }
        return new PayState(200,"支付成功","本次支付金额:"+amount);
    }

}
