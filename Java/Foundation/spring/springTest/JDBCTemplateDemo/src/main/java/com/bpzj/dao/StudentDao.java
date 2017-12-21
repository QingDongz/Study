package com.bpzj.dao;

import com.bpzj.domain.Student;

import java.util.List;

public interface StudentDao {

    //增加
    void add(Student student);
    //删除
    void deleteById(int id);
    //修改
    void updateById(Student student);
    //获取
    Student getById(int id);

    //查询
    List<Student> findAll();
    //分页查询
    List<Student> findAll(int start, int count);
}
