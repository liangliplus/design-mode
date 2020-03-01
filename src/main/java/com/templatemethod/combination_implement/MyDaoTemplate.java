package com.templatemethod.combination_implement;


public class MyDaoTemplate {
    private void openConnection(){
        System.out.println("打开连接");
    }

    private void closeConnection(){
        System.out.println("关闭连接");
    }

    public void execute(CallBack callback){
        openConnection();
        callback.dosomeThing();
        closeConnection();
    }

    public void add(final Object object){
        execute(new CallBack() {
            @Override
            public void dosomeThing() {
                System.out.println("add"+object);
            }
        });
    }

    public void update(final int uid){
        execute(new CallBack() {
            @Override
            public void dosomeThing() {
                System.out.println("update"+uid);
            }
        });
    }


}
