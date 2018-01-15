package com.bpzj.task4.service;

import com.bpzj.task4.dao.StudentMapper;
import com.bpzj.task4.domain.Student;
import com.bpzj.task4.domain.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;


    public long countTotalStudent() {
        long totalNum;
        // 创建一个条件
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        // StudyCondition 字段不为空就统计，这里统计整数
        criteria.andStudyConditionIsNotNull();
        totalNum = studentMapper.countByExample(example);
        return totalNum;
    }

    public long countWorked() {
        long workedStudentNum;
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        // 1表示得到工作。0表示没有工作，还在学习。
        criteria.andStudyConditionEqualTo(1);

        workedStudentNum = studentMapper.countByExample(example);
        return workedStudentNum;
    }

    public List<Student> listExcellent() {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andIsExcellentEqualTo(1);
        List<Student> students = studentMapper.selectByExample(example);
        return students;
    }
}
