package com.bpzj.task1.test;

import com.bpzj.task1.service.StudentService;

public class MainRepeatTest {
    private static StudentService studentService =new StudentService();

    public static void main(String[] args) {
        for (int i =1; i<1001;i++) {
            studentService.insert(i);
        }
    }
}
