package com.test;

import com.delegate.simple.Boss;
import com.delegate.simple.Leader;
import org.junit.Test;

/**
 * 委派模式测试类
 */
public class DelegateTest {
    /**
     * 客户请求（boss），委派者（leader），被委派者（员工）
     * 委派者必须持有被委派的引用，（本次案例采用的构造方法初始化容器）
     * 代理模式注重过程，委派模式注重结果。
     * 策略模式注重可扩展（外部扩展），为欧派模式注重内部灵活和复用
     * 核心：分发，调度，派遣
     * 本案例还原了经理分派任务场景
     */
    @Test
    public void testSimple(){
        Leader leader = new Leader();
        Boss boss = new Boss(leader);
        boss.command("架构",leader);

    }

}
