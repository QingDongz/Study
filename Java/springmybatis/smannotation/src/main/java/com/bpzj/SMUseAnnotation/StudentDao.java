package com.bpzj.SMUseAnnotation;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    @Insert("INSERT INTO student VALUES(#{id},NOW(),NOW(),#{name},#{qq},#{type},#{entryTime}," +
            "#{school},#{studentId},#{link},#{oath},#{brother},#{knowFrom})")
    boolean insert(Student student);

    //删除
    @Delete("DELETE FROM student WHERE id=#{id}")
    boolean deleteById(int id);

    //修改
    @Update("UPDATE student SET update_at=NOW(), name=#{name}, oath=#{oath} WHERE id=#{id}")
    boolean updateById(Student student);

    //查询
    @Select("SELECT * FROM student")
    List<Student> findAll();

    //分页查询
//    List<Student> findAll(int start, int count);

}
