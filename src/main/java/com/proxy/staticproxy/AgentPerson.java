package com.proxy.staticproxy;

import com.proxy.Person;

/**
 * 代理人
 * 静态代理不方便扩展，如果新增咨询需求，需要修改接口，目标对象和代理对象都需要修改类
 * 并且代理对象只能是代理人，
 */
public class AgentPerson {
    private Person person;

    public AgentPerson(Person person) {
        this.person = person;
    }

    public void buyInsurance(){
        //知道你的需求了
        System.out.println("了解用户的想法，有一款意外年金分红险");
        person.buyInsurance();
        System.out.println("聊的不错，适合用户,确认就准备购买了");
    }


   /* public void consult(){
        System.out.println("咨询什么");
        person.consult();
    }*/
}
