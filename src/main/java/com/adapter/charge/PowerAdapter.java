package com.adapter.charge;

/**
 * 适配器对象 采用组合的方式
 */
public class PowerAdapter implements AppleCharge {
    private PatcherBoard patcherBoard;

    public PowerAdapter(PatcherBoard patcherBoard) {
        this.patcherBoard = patcherBoard;
    }

    @Override
    public int outPutDC5() {
        int  ac220V= patcherBoard.outPut220V();
        int DC5V = ac220V / 44;
        System.out.println("给苹果手机充电，输入"+ac220V+"V"+" ,输出 ："+DC5V+"V");
        return DC5V;
    }
}
