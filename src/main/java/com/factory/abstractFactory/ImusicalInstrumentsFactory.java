package com.factory.abstractFactory;

import com.factory.IMusicalInstruments;

/**
 * 抽象工厂，理解产品族和产品等级划分，产品族可以理解为一个品牌下面有很多产品，
 * 不同品牌对相同产品的划分会有差异,每新增一个产品都需要在抽象工厂
 * 新增方法（违反开闭原则），接口新增方法，子类必须升级
 * 如果有公共逻辑可以声明为抽象类
 */
public interface ImusicalInstrumentsFactory {
    public IMusicalInstruments createMusicalInstruments();//创建乐器产品

    public Ibackpack createIbackpack();

    public Score createScore();

}
