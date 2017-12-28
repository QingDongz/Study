package com.bpzj.task1.service;

import com.bpzj.task1.dao.StudentMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MapperBean {

    // 实例化容器
    ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-druid.xml");

    // 获取mapper bean
    StudentMapper studentMapper = (StudentMapper) ctx.getBean("studentMapper");

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }




}
