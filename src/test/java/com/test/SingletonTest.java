package com.test;

import com.singleton.ThreadUtils;
import com.singleton.innerclass.InnerClassSignleton;
import com.singleton.lazysingleton.LazySingleton;
import com.singleton.register.EnumSingleton;
import com.singleton.threadlocal.ThreadLocalSingletonTest;
import com.sun.javafx.iio.ios.IosDescriptor;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {

    @Test
    public void lazyTest(){
        ThreadUtils.execute();
    }

    @Test
    public void innserClassTest(){
        ThreadUtils.execute();

    }

    @Test
    public  void containerTest(){
        ThreadUtils.executeContainerSingleton();

    }
    @Test
    public void EnumTest(){
        ThreadUtils.executeEnum();
    }

    @Test
    public void  reflectAttAckSignleton(){
        InnerClassSignleton instance = InnerClassSignleton.getInstance();
        try {
            Constructor<InnerClassSignleton> declaredConstructor = InnerClassSignleton.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            InnerClassSignleton innerClassSignleton = declaredConstructor.newInstance();

            System.out.println(instance == innerClassSignleton);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testSerialize(){
        try {
            LazySingleton obj1 = LazySingleton.getInstance();
            FileOutputStream  out = new FileOutputStream("testSerialize.obj");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(obj1);

            FileInputStream in = new FileInputStream("testSerialize.obj");
            ObjectInputStream ois = new ObjectInputStream(in);
            LazySingleton obj2 = (LazySingleton)ois.readObject();
            System.out.println("obj1 地址值"+obj1 +"\n obj2地址值"+obj2 );
            System.out.println(obj1 == obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEnumSerizlizeAttck(){
        try {
            EnumSingleton obj1 = EnumSingleton.getInstance();
            obj1.setData(new Object());
            FileOutputStream  out = new FileOutputStream("testEnumSerizlizeAttck.obj");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(obj1);

            FileInputStream in = new FileInputStream("testEnumSerizlizeAttck.obj");
            ObjectInputStream ois = new ObjectInputStream(in);
            EnumSingleton obj2 = (EnumSingleton)ois.readObject();
            System.out.println("getData 地址值"+obj1.getData() +"\n getData2 地址值"+obj2.getData() );
            System.out.println(obj1 == obj2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testEnumRelectAttck(){
        try {
            Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
            constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testThreadLocal(){
        System.out.println(ThreadLocalSingletonTest.getInstance());
        System.out.println(ThreadLocalSingletonTest.getInstance());
        System.out.println(ThreadLocalSingletonTest.getInstance());
        System.out.println(ThreadLocalSingletonTest.getInstance());
        ThreadUtils.executeThreadLocal();

        System.out.println("over");
    }
}
