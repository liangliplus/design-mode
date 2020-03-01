package com.singleton.lazysingleton;

import java.io.Serializable;

/***
 * 懒加载方式，使用双重检查，因为jvm会对指令重排序，静态单例需要加上volatile关键字
 * 懒加载使用了锁，有资源开销，不是最佳方案
 */
public class LazySingleton implements Serializable {
    private LazySingleton(){}
    private static volatile LazySingleton lazySingleton = null;

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            synchronized (LazySingleton.class){
                if(lazySingleton == null)
                    lazySingleton = new LazySingleton();
            }
        }

        return lazySingleton;

    }

    public Object readResolve(){
        return lazySingleton;
    }
}
