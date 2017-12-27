package com.bpzj.jdbcTemplate.dao;

import com.bpzj.jdbcTemplate.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {


    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("datasource.xml");

        //从spring IOC容器获取 studentDao 实例
        StudentDao studentDao = (StudentDao) ctx.getBean("studentDaoImpl");

        //测试Delete
        studentDao.deleteById(27);
        //测试 List 查找
        List<Student> studentList = studentDao.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }

        //测试 List 分页查找
        List<Student> studentList2 = studentDao.findAll(4,2);
        for (Student student : studentList2) {
            System.out.println(student);
        }

        //新建一个student 对象
        Student student= new Student(1,"新名","12345",1,"明天","清华",
                "1234","http:hello","新年好","兄弟","天下");
        //测试 update
        studentDao.updateById(student);

        //测试 add
        studentDao.add(student);

        //测试 getById
        Student student1 = studentDao.getById(4);
        System.out.println(student1);
    }
}
