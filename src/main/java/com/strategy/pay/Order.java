package com.strategy.pay;

public class Order {
    private Integer uid;
    private Integer orderId;
    private double amount;

    public Order(Integer uid, Integer orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PayState pay(){
      return PayStrategy.getPayment(PayStrategy.DEFAULT_PAY).pay(uid+"",amount);
    }

    /**
     * 避免了过多的if else
     * @param paymentKey
     * @return
     */
    public PayState pay(String paymentKey){
        Payment payment = PayStrategy.getPayment(paymentKey);
        return payment.pay(getUid()+"",getAmount());

    }
}
