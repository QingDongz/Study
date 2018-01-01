package com.bpzj.web.service;

import com.bpzj.web.dao.StudentMapper;
import com.bpzj.web.domain.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    Logger logger = Logger.getLogger(StudentService.class);

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> listStudents() {
        return studentMapper.listAll();
    }

    public void addOneStudent(Student student) {
        boolean success = studentMapper.insert(student);
        if (success) {
            logger.info("add student success");
        }
    }
}
