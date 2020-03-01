package com.factory.methodFactory;

import com.factory.Guitar;
import com.factory.IMusicalInstruments;

public class GuitarFactory implements IMusicalInstrumentsFactory {

    @Override
    public IMusicalInstruments create() {
        return new Guitar();
    }



}
