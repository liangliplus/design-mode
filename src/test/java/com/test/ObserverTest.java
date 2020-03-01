package com.test;

import com.observer.jdkobserver.Blogger;
import com.observer.jdkobserver.Fans;
import com.observer.jdkobserver.McroBlog;
import org.junit.Test;

public class ObserverTest {

    @Test
    public  void jdkObserverTest(){
        Blogger blogger = new Blogger("陶渊明","架构师篇幅,学好设计模式在面试中有那些好处？");
        McroBlog mcroBlog = new McroBlog(blogger);
        Fans fans = new Fans("小可爱");
        mcroBlog.addObserver(fans);
        mcroBlog.releaseDynamicMessage();

    }
}
