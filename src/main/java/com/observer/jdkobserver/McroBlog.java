package com.observer.jdkobserver;

import java.util.Observable;

/**
 * 微博被监视对象
 */
public class McroBlog extends Observable {

    private Blogger blogger;

    public McroBlog(Blogger blogger) {
        this.blogger = blogger;
    }

    public void releaseDynamicMessage(){
        System.out.println("博主"+blogger.getName()+" 发布新动态 ：内容是"+blogger.getContent());
        setChanged();
        notifyObservers(blogger);

    }

}
