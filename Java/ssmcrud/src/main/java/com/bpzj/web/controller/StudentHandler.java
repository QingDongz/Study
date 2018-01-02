package com.bpzj.web.controller;

import com.bpzj.web.domain.Student;
import com.bpzj.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class StudentHandler {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students")
    public String list(Map<String, Object> map) {
        List<Student> students = studentService.listStudents();
        map.put("allStudents", students);
        return "list";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String input() {
        return "input";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String add(Student student) {
        System.out.println(student);
        if (student != null) {
            studentService.addOneStudent(student);
        }
        return "redirect:/students";
    }
}
