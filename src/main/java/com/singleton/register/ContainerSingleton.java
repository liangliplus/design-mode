package com.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    private ContainerSingleton(){}

    public static  Object getInstance(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                try {
                    ioc.put(className,Class.forName(className).newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ioc.get(className);
    }



}
