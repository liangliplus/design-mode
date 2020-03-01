package com.strategy.pay;

public class PayState {
    private int code;
    private String msg;
    private Object data;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "[本次支付状态码 ："+code+"],"+msg+" 支付详情："+data;
    }
}
