package com.proxy.jdbcstaticproxy;

/**
 * 动态切换数据源实体
 * 这里根据年分库
 */
public class DynamicDataSourceEntity {
    private static ThreadLocal<String> local = new ThreadLocal<>();
    private static String DEAFULT = "";

    public static String get(){
       return local.get();
    }

    public static void set(String source){
        local.set(source);
    }

    public static void set(int year){
        local.set("DB_"+year);
    }

    public static void clear(){
        local.remove();
    }

    public static void restore(){//重置数据源
        local.set(DEAFULT);
    }


}
