package com.proxy.dynamicjdbcproxy;


import com.proxy.jdbcstaticproxy.DynamicDataSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 动态代理数据源切换（根据createTime路由，实体中必须由改字段）
 * 使用动态代理的好处，以动态数据源来说
 * 可以代理符合规则的任意类(因为我们接受对象是object)，而静态代理就需要新增为每一个service去增加一个代理
 *
 */
public class DynamicDataSourceProxy  implements InvocationHandler {
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        //改方法接受三个参数目标对象类加载器和接口列表，最后一个参数为invocationHandler
        //返回就是动态生成的代理类
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

    }


    //重写invoke 方法，method就是目标对象方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);//调用方发第一个入参为实体
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("重置数据源为默认数据源");
        DynamicDataSourceEntity.restore();

    }


    public void before(Object entity) throws Exception{
            System.out.println("dynamic proxy before reflect invoke getCreateTime" );
            Date createTime = (Date) entity.getClass().getMethod("getCreateTime", null).invoke(entity);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
            String format = sdf.format(createTime);
            System.out.println("动态切换数据源 DB_"+format+"成功");
            DynamicDataSourceEntity.set(Integer.parseInt(format));



    }
}
