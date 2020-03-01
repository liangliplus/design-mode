package com.observer.jdkobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * 粉丝
 */
public class Fans  implements Observer {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        McroBlog mcroBlog = (McroBlog) o;
        Blogger blogger = (Blogger) arg;
        System.out.println("blogger"+blogger.getContent());
        System.out.println("粉丝"+this.name +"观察到"+blogger.getName()+"博主有更新内容，内容为 ："+blogger.getContent()+"内容还算不错");

    }
}
