package com.factory.abstractFactory;

import com.factory.Guitar;
import com.factory.IMusicalInstruments;

public class PerfectGuitarFactory implements ImusicalInstrumentsFactory {
    @Override
    public IMusicalInstruments createMusicalInstruments() {
        return new Guitar();
    }

    @Override
    public Ibackpack createIbackpack() {
        return new GuitarBackPack();
    }

    @Override
    public Score createScore() {
        return new GuitarScore();
    }
}
