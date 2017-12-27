package com.bpzj.task1.test;

import com.bpzj.task1.bean.Student;
import java.util.List;


public class Task1Test {

    static MapperBean mapperBean = new MapperBean();

    public static Student newStudent() {
        Student student= new Student(1,"曲艳行","3169119846",
                1,"11月18日-22日","燕山大学",
                "2641","http://www.jnshu.com/occupation/5/daily",
                "新年好","郑州分院-王鹏举","知乎");
        return student;
    }

    public static void add() {
        Student student1 = newStudent();
        student1.setId(1);
        boolean a= mapperBean.getStudentMapper().insert(student1);
        if (a) {
            System.out.println("insert success");
        } else {
            System.out.println("insert failure");
        }
    }

    public static void delete() {
        boolean a= mapperBean.getStudentMapper().deleteById(1);
        if (a) {
            System.out.println("delete success");
        } else {
            System.out.println("delete failure");
        }
    }

    public static void listAll() {
        List<Student> students = mapperBean.getStudentMapper().listAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void listGroup(int start, int count) {
        List<Student> students = mapperBean.getStudentMapper().listGroup(start, count);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void update() {
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
    public static void getByName() {
        Student student = mapperBean.getStudentMapper().getByName("曲艳行");
        System.out.println(student);
    }

    public static Student getById(int id) {
        Student student = mapperBean.getStudentMapper().getById(id);
        // System.out.println(student);
        return student;
    }

    public static void main(String[] args) {

        System.out.println("查询所有学生:");
        listAll();

        System.out.println("\n删除id=1的学生:");
        delete();
        System.out.println("选取前两个学生验证删除成功:");
        listGroup(0,2);

        System.out.println("\n新建学生，插入id=1这一列:");
        add();
        System.out.println("选取前两个学生验证插入成功:");
        listGroup(0,2);

        System.out.println("\n更新id=1的宣言");
        update();
        System.out.println("检查更新是否成功");
        int id =1;
        Student student = getById(id);
        System.out.println("Student [id=" + id + " 宣言=" + student.getOath() + "]");
    }

}
