package com.bpzj.pool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-druid.xml")
public class StudentDaoTest {
    //测试类命名以它要测试的类名开始，以 Test 结尾
    @Autowired
    public StudentDao studentDao;

    public Student newStudent() {
        Student student= new Student(1,"新名","12345",1,"明天",
                "清华","1234","http://www.jnshu.com/occupation/5/daily",
                "新年好","兄弟","天下");
        return student;
    }

    //增
    @Test
    public void add() {
        Student student1 = newStudent();
        student1.setId(1);
        boolean a= studentDao.insert(student1);
        if (a) {
            System.out.println("insert success");
        } else {
            System.out.println("insert failure");
        }
    }

    //删
    @Test
    public void delete() {
        boolean a= studentDao.deleteById(1);
        if (a) {
            System.out.println("delete success");
        } else {
            System.out.println("delete failure");
        }
    }

    //改
    @Test
    public void update() {
        Student student1 = newStudent();
        student1.setId(2);
        student1.setOath("老大最帅");
        boolean a= studentDao.updateById(student1);
        if (a) {
            System.out.println("update success");
        } else {
            System.out.println("update failure");
        }
    }

    //查
    @Test
    public void findAll() {
        System.out.println(studentDao);
        List<Student> students =studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
