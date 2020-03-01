package com.factory.simplefactory;

import com.factory.IMusicalInstruments;

public class SimpleFactory {
    public IMusicalInstruments createMusicalInstrument(String  className){
        try {
            if(className != null && "" != className ){
               return (IMusicalInstruments) Class.forName(className).newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
