package com.templatemethod.combination_implement;

public  abstract class MyJDBCTemplate  {
    private MyDaoTemplate template;

    public MyJDBCTemplate() {
        this.template = new MyDaoTemplate();
    }

    public void add(Object o){
        template.add(o);
    }

    public void update(int uid){
        template.update(uid);
    }





}
