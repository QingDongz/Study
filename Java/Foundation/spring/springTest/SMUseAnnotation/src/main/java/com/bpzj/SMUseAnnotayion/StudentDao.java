package com.bpzj.SMUseAnnotayion;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentDao {

    @Insert("INSERT INTO sign VALUES(NULL,NOW(),NOW(),#{name},#{qq},#{type},#{entryTime}," +
            "#{school},#{studentId},#{link},#{oath},#{brother},#{knowFrom})")
    void add(Student student);

    //删除
    @Delete("DELETE FROM sign WHERE id=#{id}")
    void deleteById(int id);

    //修改
    @Update("UPDATE sign SET update_at=NOW(), name=#{name}, type=#{type}, oath=#{oath} WHERE id=#{id}")
    void updateById(Student student);

    //获取
    Student getById(int id);

    //查询
    @Select("SELECT * FROM sign")
    List<Student> findAll();

    //分页查询
//    List<Student> findAll(int start, int count);

}
