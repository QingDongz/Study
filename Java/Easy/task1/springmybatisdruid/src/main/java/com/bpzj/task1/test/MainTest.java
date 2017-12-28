package com.bpzj.task1.test;

import com.bpzj.task1.bean.Student;
import com.bpzj.task1.service.StudentService;


public class MainTest {

    private static StudentService studentService =new StudentService();

    public static void main(String[] args) {

        System.out.println("查询所有学生:");
        studentService.listAll();

        System.out.println("\n删除id=1的学生:");
        studentService.delete();
        System.out.println("选取前两个学生验证删除成功:");
        studentService.listGroup(0,2);

        System.out.println("\n新建学生，插入id=1这一列:");
        studentService.insert(1);
        System.out.println("选取前两个学生验证插入成功:");
        studentService.listGroup(0,2);

        System.out.println("\n更新id=1的宣言");
        studentService.update();
        System.out.println("检查更新是否成功");
        int id =1;
        Student student = studentService.getById(id);
        System.out.println("Student [id=" + id + " 宣言=" + student.getOath() + "]");
    }

}
