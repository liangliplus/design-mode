package com.observer.gperguava;

import com.google.common.eventbus.Subscribe;

public class Teacher {

    /**
     * 被通知
     * @param student
     * @return
     */
    @Subscribe
    public String beInform(Student student){
        System.out.println("收到 ："+student.getName()+"同学的提问\n属于"+student.getModule()+"\n 内容为：\n"+student.getContent());
        return "老师会尽快处理中";
    }

}
