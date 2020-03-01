package com.factory.abstractFactory;

public class GuitarScore implements Score {
    @Override
    public void study() {
        System.out.println("打开吉他谱，准备演奏");
    }
}
