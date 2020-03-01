package com.factory;

public class Guitar implements  IMusicalInstruments{

    @Override
    public void play() {
        System.out.println("演奏吉他，帅的一p");
    }
}
