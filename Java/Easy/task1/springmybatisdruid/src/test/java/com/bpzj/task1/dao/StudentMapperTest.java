package com.bpzj.task1.dao;

import com.bpzj.task1.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-druid.xml")
public class StudentMapperTest {
    //测试类命名以它要测试的类名开始，以 Test 结尾
    @Autowired
    public StudentMapper studentMapper;

    public Student newStudent() {
        Student student= new Student(1,"新名","12345",1,"明天",
                "xx大学","1234","http://www.jnshu.com/occupation/5/daily",
                "新年好","兄弟","天下");
        return student;
    }

    // 增
    @Test
    public void add() {
        Student student1 = newStudent();
        student1.setId(1);
        boolean a= studentMapper.insert(student1);
        if (a) {
            System.out.println("insert success");
        } else {
            System.out.println("insert failure");
        }
    }

    // 删
    @Test
    public void delete() {
        boolean a= studentMapper.deleteById(1);
        if (a) {
            System.out.println("delete success");
        } else {
            System.out.println("delete failure");
        }
    }

    // 改
    @Test
    public void update() {
        Student student = newStudent();
        student.setId(2);
        student.setName("曲艳行");
        student.setOath("老大最帅");
        boolean a= studentMapper.updateById(student);
        if (a) {
            System.out.println("update success");
        } else {
            System.out.println("update failure");
        }
    }

    // 查
    @Test
    public void listAll() {
        List<Student> students = studentMapper.listAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 根据姓名查询
    @Test
    public void getByName() {
        Student student = studentMapper.getByName("曲艳行");
        System.out.println(student);
    }
}
