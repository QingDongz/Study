package com.bpzj.task4.dao;

import com.bpzj.task4.domain.Student;
import com.bpzj.task4.domain.StudentExample;
import java.util.List;

import com.bpzj.task4.domain.StudentWithJobName;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<StudentWithJobName> selectStudentWithJobName();

    String getJobName(Student student);
}