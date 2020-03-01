package com.singleton.register;

/**
 * 枚举自身就是一个单例类
 * 源码中，使用饿汉式创建对象
 * 为什么枚举不能被反射和序列化破坏，java枚举考虑过上面两种问题
 * Enum<?> en = Enum.valueOf((Class)cl, name);
 * 这段代码就是反序列化会走到的代码，枚举类通过类和类名找到唯一一个对象
 * 所以枚举对象不可能被加载多次
 * 为什么不能反射 因为protected Enum(String name, int ordinal)
 * java Enum类是被声明为受保护的
 * 我们返回所有构造方法，设置允许访问（true）
 * 运行会得到  Cannot reflectively create enum objects
 * 可以查看Constructor的newInstance方法，中判断为枚举类型不能创建
 *
 *
 *
 */
public enum EnumSingleton {
    INSTANCE;


    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
