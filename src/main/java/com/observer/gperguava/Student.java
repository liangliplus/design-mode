package com.observer.gperguava;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private static List<String> addStudent = new ArrayList<>();
    private String name;
    private String content;
    private String module;//模块

    public Student() {
    }

    public Student(String name, String content, String module) {
        this.name = name;
        this.content = content;
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }


    public static void main(String[] args) {
        /*EventBus eventBus = new EventBus();
        eventBus.register(new Teacher());
        eventBus.post(new Student("张三","如何深层次的了解spring源码","源码分析"));*/

        //消息总线有两种实现 ：同步实现EventBus和异步实现AsyncEventBus

        /*EventBus eventBus = new EventBus();
        eventBus.register(new Object(){
            @Subscribe
            //guava 发布的事件默认不会处理线程安全的，加上AllowConcurrentEvents可以使得线程变得安全
            @AllowConcurrentEvents
            public void way01(String param){
               if(addStudent.size() == 0){
                   addStudent.add("张三");
               }
                System.out.println("studentSize"+addStudent.size());
            }

        });
        eventBus.post("ok");*/


        /**
         * guava是通过post方法发布事件的
         * 是依据上例中订阅方法的方法参数类型决定的，换而言之就是post传入的类型和订阅方法的 参数类型
         * 和 其基类类型都可以一起收到此事件
         */
        /*final EventBus eventBus = new EventBus();
        eventBus.register(new Object() {

            @Subscribe
            public void lister(Integer integer) {
                System.out.printf("%s from int%n", integer);
            }

            @Subscribe
            public void lister(Number integer) {
                System.out.printf("%s from Number%n", integer);
            }

            @Subscribe
            public void lister(Long integer) {
                System.out.printf("%s from long%n", integer);
            }
        });

        eventBus.post(1);
//        eventBus.post(1L);
*/
        /**
         * guava 的post方法没有找到或者post中参数为null就会抛出异常
         * 可以使用DeadEvent 异常处理
         */

        final EventBus eventBus = new EventBus();
        eventBus.register(new Object() {

            @Subscribe
            public void lister(DeadEvent event) {
                System.out.printf("%s=%s from dead events%n", event.getSource().getClass(), event.getEvent());
                System.out.println("111");
            }
        });

        eventBus.post("1");


    }
}
