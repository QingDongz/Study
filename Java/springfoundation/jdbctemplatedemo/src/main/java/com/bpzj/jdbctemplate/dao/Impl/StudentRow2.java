package com.bpzj.jdbctemplate.dao.Impl;

import com.bpzj.jdbctemplate.domain.Student;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRow2 implements RowCallbackHandler {

    final List<Student> studentList = new ArrayList<>();
    @Override
    public void processRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong(1));
        student.setCreateAt(resultSet.getLong(2));
        student.setUpdateAt(resultSet.getLong(3));
        student.setName(resultSet.getString(4));
        student.setQq(resultSet.getString(5));
        student.setType(resultSet.getShort(6));
        student.setEntryTime(resultSet.getString(7));
        student.setSchool(resultSet.getString(8));
        student.setStudentId(resultSet.getString(9));
        student.setLink(resultSet.getString(10));
        student.setOath(resultSet.getString(11));
        student.setBrother(resultSet.getString(12));
        student.setKnowFrom(resultSet.getString(13));
        studentList.add(student);
    }

    public StudentRow2(List<Student> studentList) {
    }
}
