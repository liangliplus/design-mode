package com.test;

import com.prototype.deepcopy.deepCopyPerson;
import com.prototype.shallowcopy.Person;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {
    /**
     * 浅克隆只会拷贝值类型，引用类型拷贝的对象地址值
     */
    @Test
    public void shallowCopyTest(){
        List<String> list = new ArrayList<>();
        list.add("跳舞");
        list.add("唱歌");
        list.add("弹琴");
        Person person = new Person("张三",18,list);
        try {
            Person clone = person.clone();
            person.speciality.add("画画");
            System.out.println("clone speciality size"+clone.speciality.size());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void deepCopy(){
        List<String> list = new ArrayList<>();
        list.add("跳舞");
        list.add("唱歌");
        list.add("弹琴");
        deepCopyPerson person = new deepCopyPerson("张三",19,list);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("deepCopyPerson.obj"));
            oos.writeObject(person);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("deepCopyPerson.obj"));
            byte[]  bytes = new byte[ois.available()];
            deepCopyPerson o = (deepCopyPerson)ois.readObject();
            person.speciality.add("书法");//打印是3 修改原始对象对克隆对象没影响
            System.out.println("clone speciality size"+o .speciality.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
