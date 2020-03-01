# design-mode

#### 介绍
设计模式代码板块

###image 为类图，时序图等 

###src 下面根据模式命令 如com.factory 表示工厂模式





#单例

##单例模式有哪些
饿汉式，懒汉式（双重检查），静态内部类，注册式（枚举式，容器式）
对单个线程而言的ThreadLocal

##如何解决反射和反序列化破坏单例 
反射： 可以在构造方法判断是否创建过来抛出异常 
反序列化  重写readResolve();
或者采用枚举，jdk考虑过上述两个问题。


##优缺点
优点：在内存只有一个实例，节约内存，避免对资源的多重占用。
缺点：不利于扩展，增加需要就需要修改单例类

总结：私有构造函数，

##为什么在动态代理中判断接口数65535
由于java使用UNICODE标准字符集，为16位，因此一共能表示2的16次方个字符，即65535个

 


