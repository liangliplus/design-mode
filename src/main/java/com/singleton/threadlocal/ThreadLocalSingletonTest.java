package com.singleton.threadlocal;


/**
 * 不能保证全局唯一，保证线程间唯一
 * 对象保存在ThreadLocalMap中
 */
public class ThreadLocalSingletonTest {
    private ThreadLocalSingletonTest(){}


    public static final ThreadLocal<ThreadLocalSingletonTest> THREAD_LOCAL = new ThreadLocal<ThreadLocalSingletonTest>(){
        @Override
        protected ThreadLocalSingletonTest initialValue() {
            return new ThreadLocalSingletonTest();
        }
    };


    public static ThreadLocalSingletonTest getInstance(){
        return THREAD_LOCAL.get();
    }

}
