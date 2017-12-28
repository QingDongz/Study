package com.bpzj.jdbctemplate.task1;

public class Student {
    private String name;

    public void setName(String name) {
        System.out.println("setName" + name);
        this.name = name;
    }

    public void hello() {
        System.out.println("hello" + this.name);
    }

    public Student() {
        System.out.println("student类的 构造器 运行");
    }
}
