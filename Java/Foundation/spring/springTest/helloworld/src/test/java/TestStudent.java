//package com.bpzj.task1;

import com.bpzj.task1.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    public static void main(String[] args) {

        //创建 spring 的 ioc 对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从ioc容器获bean对象
        Student helloWorld = (Student) ctx.getBean("student");

        helloWorld.hello();
    }
}
