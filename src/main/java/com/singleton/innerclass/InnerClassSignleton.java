package com.singleton.innerclass;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * 了解内部类加载机制。静态成员没有被调用时不会被加载，jvm保证静态成员只会被加载一次
 * 所以保证了懒加载和线程安全
 * 即没有浪费资源，也保证了线程安全
 *
 */
public class InnerClassSignleton {
    private InnerClassSignleton(){
        if(lazyInnerClass.lazy != null){
            throw new RuntimeException("防止反射攻击，抛出异常。。");
        }
    };

    //默认不加载，调用了getInstance方法时加载
    private static class lazyInnerClass{
        private static final InnerClassSignleton lazy = new InnerClassSignleton();
    }

    /**
     * static 使单例对象内存空间共享
     * final 防止被重写，重载发生覆盖
     * @return
     */
    public static final InnerClassSignleton getInstance(){
        return lazyInnerClass.lazy;

    }
}
