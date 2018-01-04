package com.bpzj.web.controller;

import com.bpzj.web.domain.Student;
import com.bpzj.web.domain.Msg;
import com.bpzj.web.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public Msg getStudentsUseJson(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 引入 pageHelper 分页，startPage参数(第几页，每页几条数据)
        // 紧跟的这句就会分页查询，结果保存在pageInfo
        PageHelper.startPage(pn, 5);
        List<Student> list = studentService.getAll();
        // pageInfo 封装了查询后的结果，注意后面的 navigatePages，默认为 8，这里指定为5
        PageInfo page = new PageInfo(list, 5);
        return Msg.success().add("pageInfo", page);
    }

    //    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public String getStudents(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            Model model) {
        // 引入 pageHelper 分页，startPage参数(第几页，每页几条数据)
        // 紧跟的这句就会分页查询，结果保存在pageInfo
        PageHelper.startPage(pn, 5);
        List<Student> list = studentService.getAll();
        // pageInfo 封装了查询后的结果，注意后面的 navigatePages，默认为 8，这里指定为5
        PageInfo page = new PageInfo(list, 5);
        model.addAttribute("pageInfo", page);
        return "list";
    }

    // 学生保存
    // REST 风格，POST请求
    //      /student    Post请求，新增

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveStudent(Student student) {
        studentService.saveStudent(student);
        return Msg.success();
    }

    // 查询一个学生
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        return Msg.success().add("student", student);
    }

    // 更新
    // 注意 value = "/students/{id}" 这个{}中的名称应该和domain层的 Student
    // 的主键字段名一致，才能封装成功。这里 Student 的主键字段就是 "id"
    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateStudent(@PathVariable("id") Long id, Student student) {
        System.out.println(student);
        studentService.updateStudent(student);
        return Msg.success();
    }

    // 删除
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return Msg.success();
    }
}
