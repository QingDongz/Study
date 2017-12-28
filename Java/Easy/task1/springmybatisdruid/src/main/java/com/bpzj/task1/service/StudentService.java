package com.bpzj.task1.service;

import com.bpzj.task1.bean.Student;

import java.util.List;

public class StudentService {

    static MapperBean mapperBean = new MapperBean();

    public Student newStudent() {
        Student student= new Student(1,"曲艳行","3169119846",
                1,"11月18日-22日","燕山大学",
                "2641","http://www.jnshu.com/occupation/5/daily",
                "新年好","郑州分院-王鹏举","知乎");
        return student;
    }

    public void insert() {
        Student student1 = newStudent();
        student1.setId(1);
        boolean a= mapperBean.getStudentMapper().insert(student1);
        if (a) {
            System.out.println("insert success");
        } else {
            System.out.println("insert failure");
        }
    }

    public void insert(long id) {
        Student student1 = newStudent();
        student1.setId(id);
        boolean a= mapperBean.getStudentMapper().insert(student1);
        if (a) {
            System.out.println("insert data id=" + id +" success");
        } else {
            System.out.println("insert data id=" + id +" failure");
        }
    }

    public void delete() {
        boolean a= mapperBean.getStudentMapper().deleteById(1);
        if (a) {
            System.out.println("delete success");
        } else {
            System.out.println("delete failure");
        }
    }

    public void listAll() {
        List<Student> students = mapperBean.getStudentMapper().listAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void listGroup(int start, int count) {
        List<Student> students = mapperBean.getStudentMapper().listGroup(start, count);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void update() {
        Student student = newStudent();
        student.setId(1);
        student.setOath("老大最帅");
        boolean a= mapperBean.getStudentMapper().updateById(student);
        if (a) {
            System.out.println("update success");
        } else {
            System.out.println("update failure");
        }
    }

    // 根据姓名查询
    public void getByName() {
        Student student = mapperBean.getStudentMapper().getByName("曲艳行");
        System.out.println(student);
    }

    public Student getById(int id) {
        Student student = mapperBean.getStudentMapper().getById(id);
        // System.out.println(student);
        return student;
    }

}
