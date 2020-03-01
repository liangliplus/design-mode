package com.proxy;

import com.proxy.Person;

public class ZhangSan implements Person {

    @Override
    public void buyInsurance() {
        System.out.println("我要买保险，保障人身安全和年利润分红");
    }

  /*  @Override
    public void consult() {
        System.out.println("咨询普通产品");
    }*/
}
