package com.proxy.customerjdkproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CustomerProxy {
    private static final String LN = "\t\n";

    public static Object newProxyInstance(CustomerClassloader loader,
                                          Class<?>[] interfaces,
                                       CustomerInvocationHandler h){
        try {
            //1.生成源代码 .java
            String source = generateSrc(interfaces);

            //2. 把源代码写到磁盘
            //获取类的资源路径，点了ClassLoader就是根路径
            File f = new File(CustomerProxy.class.getResource("").getPath() + "$Proxy0.java");
            System.out.println("filePath"+f.getPath());
            FileWriter fileWriter = new FileWriter(f);
            fileWriter.write(source);
            fileWriter.flush();
            fileWriter.close();

            //3. 编译我们的java文件为.class
            JavaCompiler javaCompiler =  ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager(null,null,null);
            Iterable<? extends JavaFileObject> it = standardFileManager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardFileManager, null, null, null, it);
            task.call();//提交编译任务

            //4. 通过自定义的类加载器加载.class文件
            Class<?> clazz   = new CustomerClassloader().findClass("$Proxy0");
            Constructor<?> constructor = clazz.getConstructor(CustomerInvocationHandler.class);

            //5.删除.java文件并返回新创建的对象
            f.delete();
            return constructor.newInstance(h);


        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 以$打头的是动态生成的对象 后面的数字便是第几个
     * @param interfaces
     */
    private static String generateSrc(Class<?>[] interfaces) {//这里只实现了一个接口
        StringBuilder builderSrc = new StringBuilder();
        builderSrc.append("package com.proxy.customerjdkproxy;"+LN);
        builderSrc.append("import com.proxy.Person;"+LN);
        builderSrc.append("import java.lang.reflect.Method;"+LN);

        builderSrc.append("public class $Proxy0 implements "+interfaces[0].getName()+"{"+LN);
            builderSrc.append("CustomerInvocationHandler h;"+LN);
            builderSrc.append("public $Proxy0(CustomerInvocationHandler h){");
                builderSrc.append("this.h = h;"+LN);
            builderSrc.append("}"+LN);//构造函数结束
            for (Method method : interfaces[0].getMethods()){

                builderSrc.append("public final "+method.getReturnType().getName()+" "+method.getName() +"(){"+LN);
                    builderSrc.append("try{"+LN);
                        builderSrc.append("Method m ="+interfaces[0].getName()+".class.getMethod(\""+method.getName()+"\",new Class[]{});"+LN);
                        builderSrc.append(" h.invoke(this,m,null);"+LN);
                    builderSrc.append("}catch(Throwable e){"+LN);
                        builderSrc.append("e.printStackTrace();"+LN);
                    builderSrc.append("}"+LN);
                builderSrc.append("}"+LN);

            }

        builderSrc.append("}");
        return builderSrc.toString();

    }
}
