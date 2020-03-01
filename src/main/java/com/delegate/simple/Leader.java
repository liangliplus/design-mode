package com.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目经理类
 */
public class Leader implements IEmployee{
    private  Map<String,IEmployee> target = new HashMap<>();


    public Leader() {
        target.put("加密",new EmployeeA());
        target.put("架构",new EmployeeB());
}

    @Override
    public void doSomeThing(String command) {
        target.get(command).doSomeThing(command);
    }
}
