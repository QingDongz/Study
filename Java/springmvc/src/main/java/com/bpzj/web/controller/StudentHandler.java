package com.bpzj.web.controller;

import com.bpzj.web.domain.Student;
import com.bpzj.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class StudentHandler {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students")
    public String list(Map<String,Object> map) {
        List<Student> students = studentService.listStudents();
        map.put("allStudents", students);
        return "list";
    }

}
