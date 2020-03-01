package com.delegate.simple;

public class EmployeeA implements IEmployee{
    @Override
    public void doSomeThing(String command) {
        System.out.println("我擅长算法，接受到"+command+"命令，开始工作");
    }
}
