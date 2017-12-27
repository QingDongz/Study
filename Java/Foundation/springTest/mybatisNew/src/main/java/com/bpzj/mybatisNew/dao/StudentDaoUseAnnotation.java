package com.bpzj.mybatisNew.dao;

import com.bpzj.mybatisNew.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentDaoUseAnnotation {

    @Insert("INSERT INTO student VALUES(NULL,NOW(),NOW(),#{name},#{qq},#{type},#{entryTime}," +
            "#{school},#{studentId},#{link},#{oath},#{brother},#{knowFrom})")
    void add(Student student);

    //删除
    @Delete("DELETE FROM student WHERE id=#{id}")
    void deleteById(int id);

    //修改
    @Update("UPDATE student SET update_at=NOW(), name=#{name}, type=#{type}, oath=#{oath} WHERE id=#{id}")
    void updateById(Student student);

    //获取
    Student getById(int id);

    //查询
    @Select("SELECT * FROM student")
    List<Student> findAll();

    //分页查询
//    List<Student> findAll(int start, int count);

}
