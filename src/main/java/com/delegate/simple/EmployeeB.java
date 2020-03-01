package com.delegate.simple;

import org.springframework.web.servlet.DispatcherServlet;

public class EmployeeB implements IEmployee {
    @Override
    public void doSomeThing(String command) {
        System.out.println("我是员工B，我擅长架构,接受到"+command+"命令，开始重构代码");
    }
}
