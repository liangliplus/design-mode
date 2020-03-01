package com.singleton.serialize;

import java.io.*;

public class SerializeSingleton implements  Serializable{
    private static final SerializeSingleton hungry = new SerializeSingleton();
    private SerializeSingleton(){}

    public static SerializeSingleton getInstance(){
        return hungry;
    }
    // 序列化就是把内存中的对象转为字节码的形式
    //通过io流，写入到（磁盘，网络中等）
    //将内存中的状态持久化


    //反序列化将持久化的内存，转为io流，
    //通过io流读取，进而将读取的内容转换为java对象
    //在转换过程中会重新创建对象



    /**
     * /因为反序列化会重新新建对象，生成完对象会判断客户端是否实现readResolve方法
     * 如果实现， invokeReadResolve进行赋值
     * 通过源码可以发现对象创建了两次，创建对象频率增加，内存开销也会增大
     * @return
     */
    public Object readResolve(){
        return hungry;

    }


    public static void main(String[] args) {
        try {


            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\SerializeSingleton.obj"));
            oos.writeObject(hungry);
            oos.flush();
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\SerializeSingleton.obj"));
            SerializeSingleton o = (SerializeSingleton)ois.readObject();
            ois.close();
            System.out.println("hungry:"+hungry);
            System.out.println("serializeObj:"+o);
            System.out.println(hungry == o);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
