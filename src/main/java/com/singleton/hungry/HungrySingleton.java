package com.singleton.hungry;

/**
 * 不管是否使用，都会创建对象，这样的对象如果很多，浪费内存。
 */
public class HungrySingleton {
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton(){}

    public static  HungrySingleton getInstance(){
        return HUNGRY_SINGLETON;
    }



}
