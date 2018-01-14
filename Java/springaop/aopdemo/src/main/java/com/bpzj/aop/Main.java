package com.bpzj.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // 1. 创建spring ioc容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 从IOC容器获取bean，两种写法：
        // Calculate calculate = (Calculate) ctx.getBean("calculateImpl");
        // 下面的写法要保证接口的实现类只有一个，才能正确获得bean
        Calculate calculate = ctx.getBean(Calculate.class);

        int result = calculate.add(1, 2);
        System.out.println("结果为"+result);

        int result1 = calculate.mul(1, 2);
        System.out.println("结果为"+result1);

    }
}
