//package com.bpzj.task1;

import com.bpzj.task1.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    public static void main(String[] args) {

        //创建 spring 的 ioc 对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从ioc容器获bean对象
        Student helloWorld = (Student) ctx.getBean("student");

        helloWorld.hello();

        //通过类
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        Person person2 = (Person) ctx.getBean("person2");
        System.out.println(person2);

        Person person3 = (Person) ctx.getBean("person3");
        System.out.println(person3);
    }
}
