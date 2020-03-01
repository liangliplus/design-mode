package com.factory.methodFactory;

import com.factory.IMusicalInstruments;

/**
 * 工厂方法，符合单一职能原则，每新增一个产品都需要新增一个工厂类，容易遭类大量增加
 */
public interface IMusicalInstrumentsFactory {
    public IMusicalInstruments create();
}
