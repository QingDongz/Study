package com.bpzj.task4.controller;

import com.bpzj.task4.domain.Job;
import com.bpzj.task4.domain.StudentWithJobName;
import com.bpzj.task4.service.JobService;
import com.bpzj.task4.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TilesController {
    private Logger logger = Logger.getLogger(TilesController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/tiles10")
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
        model.addAttribute("students", excellentStudents);
        return "10";
    }

    // t11首页
    @RequestMapping(value = "/tiles11")
    public String t11Controller(Model model) {
        // 获得所有职业 列表形式
        List<Job> jobs = jobService.listAllJob();
        model.addAttribute("jobs", jobs);

        // 获取每个职业，正在学习的人数
        List<Long> jobStudyingNumbers = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            long num = studentService.countJobStudyingNumbers(job);
            jobStudyingNumbers.add(num);
        }
        model.addAttribute("numbers", jobStudyingNumbers);
        return "11";
    }


    //
    @RequestMapping(value = "/tiles")
    public String testTiles() {
        return "layout1";
    }

    @RequestMapping(value = "/tiles2")
    public String layout2() {
        return "layout2";
    }
}
