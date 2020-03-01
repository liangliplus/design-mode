package com.adapter.charge;

/**
 * 标准电压220v 插线版 adaptee 需要适配的接口
 */
public class PatcherBoard {
    public int outPut220V(){
        int output220V = 220;
        System.out.println("输出电压"+output220V+"V");
        return output220V;
    }
}
