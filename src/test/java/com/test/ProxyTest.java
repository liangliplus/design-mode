package com.test;

import com.proxy.*;
import com.proxy.cglib.CglibAgentProxy;
import com.proxy.customerjdkproxy.AgentCustomerProxy;
import com.proxy.customerjdkproxy.CustomerClassloader;
import com.proxy.customerjdkproxy.CustomerProxy;
import com.proxy.dynamicjdbcproxy.DynamicDataSourceProxy;
import com.proxy.dynamicproxy.JDKAgentProxy;
import com.proxy.jdbcstaticproxy.*;
import com.proxy.staticproxy.AgentPerson;
import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Date;

/**
 * 代理模式体现的是一种增强，表示代理对象帮助目标对象对一件事情增强，做决定的还是目标对象
 */
public class ProxyTest {
    @Test
    public void staticProTest(){
        Person zhangSan = new ZhangSan();
        AgentPerson agentPerson = new AgentPerson(zhangSan); //只能帮张三买保险
        agentPerson.buyInsurance();
    }

    @Test
    public void dynamicTest(){
        try {
            Person instance = (Person)new JDKAgentProxy().getInstance(new Wangwu());
            //以买保险为例，查看jdk动态生成的类字节码文件
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream outputStream = new FileOutputStream(new File("d:\\$Proxy0.class"));
            outputStream.write(bytes);
            outputStream.close();
//            instance.consult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dynamicDataSourceStaticProxyTest(){
        Order order = new Order();
        order.setId(111);
        order.setCreateTime(new Date());
        IorderService iorderService = new OrderServiceStaticProxy(new OrderServiceImpl());
        //在service的insert方法前后加上增强 动态切换数据源
        iorderService.insertOrder(order);
    }


    @Test
    public void jdbcDynamicProxy(){
        Order order = new Order();
        order.setId(111);
        order.setCreateTime(new Date());
        IorderService instance = (IorderService)new DynamicDataSourceProxy().getInstance(new OrderServiceImpl());
        instance.insertOrder(order);

    }

    @Test
    public void customerJdkProxyTest(){
        Person instance = (Person) new AgentCustomerProxy().getInstance(new ZhangSan());
        instance.buyInsurance();
        System.out.println("有趣。");

    }
    @Test
    public void CglibTest(){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"d:\\cglib_class");
        LiShi instance = (LiShi) new CglibAgentProxy().getInstance(new LiShi());
        instance.buyInsurance();

    }
}
