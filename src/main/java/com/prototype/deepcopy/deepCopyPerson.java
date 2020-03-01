package com.prototype.deepcopy;

import java.io.Serializable;
import java.util.List;

/**
 * 深拷贝通过序列化与反序列化来实现
 */
public class deepCopyPerson implements Serializable {
    public String name;
    public Integer age;
    public List<String> speciality;

    public deepCopyPerson(String name, Integer age, List<String> speciality) {
        this.name = name;
        this.age = age;
        this.speciality = speciality;
    }

}


