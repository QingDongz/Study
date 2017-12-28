package com.bpzj.task1.dao;

import com.bpzj.task1.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface StudentMapper {

    boolean insert(Student student);

    //删除
    boolean deleteById(int id);

    //修改
    boolean updateById(Student student);

    //获取
    Student getByName(String name);
    Student getById(int id);

    //查询
//    @Select("SELECT * FROM student")
    List<Student> listAll();

    //分组查询
//    @Select("SELECT * FROM student LIMIT #{start},#{count}")
    List<Student> listGroup(@Param("start") int start,@Param("count") int count);

}
