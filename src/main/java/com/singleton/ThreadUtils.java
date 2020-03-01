package com.singleton;

import com.singleton.innerclass.InnerClassSignleton;
import com.singleton.register.ContainerSingleton;
import com.singleton.register.EnumSingleton;
import com.singleton.threadlocal.ThreadLocalSingletonTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadUtils {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);


    /**
     * 提交10个线程获取
     */
    public static void execute(){
        for (int i = 0;i<10;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    InnerClassSignleton instance = InnerClassSignleton.getInstance();
                    System.out.println("threadName"+Thread.currentThread().getName()+instance);
            }
            });
        }
    }

    /**
     * 容器单例执行线程方法
     */
    public static void executeContainerSingleton(){
        for (int i = 0;i<10;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    ContainerSingleton instance = (ContainerSingleton)ContainerSingleton.getInstance(ContainerSingleton.class.getName());
                    System.out.println("threadName"+Thread.currentThread().getName()+instance);
                }
            });
        }
    }


    /**
     * 容器单例执行线程方法
     */
    public static void executeEnum(){
        for (int i = 0;i<10;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    EnumSingleton instance = EnumSingleton.getInstance();
                    System.out.println("threadName"+Thread.currentThread().getName()+instance.getData());
                }
            });
        }
    }



    /**
     * 容器单例执行线程方法
     */
    public static void executeThreadLocal(){
        for (int i = 0;i<10;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("threadName"+Thread.currentThread().getName()+" threadlocal:"+ ThreadLocalSingletonTest.getInstance());
                }
            });
        }
    }
}
