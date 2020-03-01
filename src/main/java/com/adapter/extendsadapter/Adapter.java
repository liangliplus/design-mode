package com.adapter.extendsadapter;

public class Adapter extends Adaptee implements Target {
    /**
     * 由于我们的父类Adaptee没有dosomeThing2方法
     * 适配器补充上这个方法
     */
    @Override
    public void dosomeThing2() {
        //做适配工作
    }
}
