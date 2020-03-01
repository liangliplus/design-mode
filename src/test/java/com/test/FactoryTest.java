package com.test;

import com.factory.IMusicalInstruments;
import com.factory.abstractFactory.ImusicalInstrumentsFactory;
import com.factory.abstractFactory.PerfectGuitarFactory;
import com.factory.methodFactory.GuitarFactory;
import com.factory.methodFactory.IMusicalInstrumentsFactory;
import com.factory.methodFactory.ViolinFactory;
import com.factory.simplefactory.SimpleFactory;
import org.junit.Test;

public class FactoryTest {
    @Test
    public void testSimple(){
        SimpleFactory simpleFactory = new SimpleFactory();
        IMusicalInstruments musicalInstrument = simpleFactory.createMusicalInstrument("com.factory.Guitar");
        musicalInstrument.play();

    }


    @Test
    public void testFactoryMethod(){
        IMusicalInstrumentsFactory factory = new GuitarFactory();
        IMusicalInstruments musicalInstrument = factory.create();
        musicalInstrument.play();
        factory = new ViolinFactory();
        factory.create().play();
    }

    @Test
    public void testAbstractFactory(){
        ImusicalInstrumentsFactory abstractFactory = new PerfectGuitarFactory();//
        abstractFactory.createScore().study();
        abstractFactory.createMusicalInstruments().play();
        abstractFactory.createIbackpack().close();

    }

}
