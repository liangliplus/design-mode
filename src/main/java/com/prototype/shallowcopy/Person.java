package com.prototype.shallowcopy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 浅拷贝 我们通过实现接口调用Object clone方法
 *
 */
public class Person implements  Cloneable {
    public String name;
    public Integer age;
    public List<String> speciality;

    public Person(){}

    public Person(String name, Integer age, List<String> speciality) {
        this.name = name;
        this.age = age;
        this.speciality = speciality;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }


}
