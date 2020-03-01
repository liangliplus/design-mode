package com.factory.methodFactory;

import com.factory.IMusicalInstruments;
import com.factory.Violin;
import com.factory.abstractFactory.ImusicalInstrumentsFactory;

public class ViolinFactory implements IMusicalInstrumentsFactory {
    @Override
    public IMusicalInstruments create() {
        return new Violin();
    }
}
