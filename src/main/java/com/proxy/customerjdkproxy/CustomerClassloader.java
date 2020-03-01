package com.proxy.customerjdkproxy;

import java.io.*;

public class CustomerClassloader extends ClassLoader {



    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String className = CustomerClassloader.class.getPackage().getName()+"."+name;
//        System.out.println("className"+className);
        File classFile = new File(CustomerClassloader.class.getResource("").getFile()+name+".class");
//        System.out.println(classFile.getPath());
        if(classFile.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                int len;
                byte[] bytes  = new byte[in.available()];
                while((len = in.read(bytes)) != -1){
                    out.write(bytes,0,len);
                }
                //defineClass 关于参数className 需要以.间隔
                return super.defineClass(className, out.toByteArray(), 0, out.size());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if(in != null) in.close();
                    if(out!= null) out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }



}
