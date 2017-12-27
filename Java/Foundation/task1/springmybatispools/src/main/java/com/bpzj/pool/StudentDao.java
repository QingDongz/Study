package com.bpzj.pool;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface StudentDao {

    boolean insert(Student student);

    //删除
    boolean deleteById(int id);

    //修改
    boolean updateById(Student student);

    //获取
    Student getById(int id);

    //查询
    List<Student> findAll();

    //分页查询
//    List<com.bpzj.pool.Student> findAll(int start, int count);

}
