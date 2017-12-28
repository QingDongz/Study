package com.bpzj.SMUseXML;

import java.util.List;

public interface StudentDao {

    void insert(Student student);

    //删除
    void deleteById(int id);

    //修改
    void updateById(Student student);

    //获取
    Student getById(int id);

    //查询
    List<Student> listAll();

    //分页查询
//    List<Student> listAll(int start, int count);

}
