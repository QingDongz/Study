package com.bpzj.mybatisNew.dao;

import com.bpzj.mybatisNew.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {

        //增加
    void add(Student student);
    //删除
    void deleteById(int id);
    //修改
    void updateById(Student student);

    //查询
    List<Student> findAll();

    //分页查询
//    List<Student> findAll(int start, int count);


}
