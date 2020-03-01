package com.factory.abstractFactory;

public class GuitarBackPack implements Ibackpack {
    @Override
    public void close() {
        System.out.println("演奏完毕,把吉他放入背包");
    }
}
