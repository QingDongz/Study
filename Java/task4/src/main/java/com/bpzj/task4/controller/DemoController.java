package com.bpzj.task4.controller;

import com.bpzj.task4.dao.StudentMapper;
import com.bpzj.task4.domain.Student;
import com.bpzj.task4.domain.Student;
import com.bpzj.task4.domain.StudentWithJobName;
import com.bpzj.task4.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class DemoController {
    private Logger logger = Logger.getLogger(DemoController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/t10index")
    public String t10Controller(Model model) {
        // 累计学习人数和已经找到工作人数
        long totalNum = studentService.countTotalStudent();
        model.addAttribute("totalNum", totalNum);

        long workedNum = studentService.countWorked();
        model.addAttribute("workedNum", workedNum);

        // 优秀学员展示，缺少职业名称的信息
        // List<Student> excellentStudents = studentService.listExcellent();

        // 改用这个方法
        List<StudentWithJobName> excellentStudents = studentService.listExcellect();
        model.addAttribute("students",excellentStudents);
        return "/t10index";
    }

    // t11首页
    @RequestMapping(value = "/t11index")
    public String t11Controller() {
        logger.info("d");
        return "/t11index";
    }


    // 使用json传递数据
    @RequestMapping(value = "/t10usejson")
    @ResponseBody
    public String t10UseJson() {
        return "";
    }
}
