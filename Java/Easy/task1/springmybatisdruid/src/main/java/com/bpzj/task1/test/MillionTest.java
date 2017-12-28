package com.bpzj.task1.test;

import com.bpzj.task1.service.StudentService;

public class MillionTest {
    private static StudentService studentService =new StudentService();

    // 经过测试，插入100万数据需要77min，这个框架和sql语句的差别真是太大了
    public static void main(String[] args) {
        for (long id = 1; id < 1000001; id++) {
            studentService.insert(id);
        }
    }

}
