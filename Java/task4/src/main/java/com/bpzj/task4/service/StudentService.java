package com.bpzj.task4.service;

import com.bpzj.task4.dao.StudentMapper;
import com.bpzj.task4.domain.Student;
import com.bpzj.task4.domain.StudentExample;
import com.bpzj.task4.domain.StudentWithJobName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;


    public long countTotalStudent() {
        /**
         * 获取所有学生数量
         */
        long totalNum;
        // 创建一个条件
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        // StudyCondition 字段不为空就统计，这里统计整数
        criteria.andIsStudyingIsNotNull();
        totalNum = studentMapper.countByExample(example);
        return totalNum;
    }

    public long countWorked() {
        /**
         * 获取已经工作的学生数量
         */
        long workedStudentNum;
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        // 1表示还在学习，没有工作。0表示有工作，不在学习。
        criteria.andIsStudyingEqualTo(0);

        workedStudentNum = studentMapper.countByExample(example);
        return workedStudentNum;
    }

    public List<Student> listExcellent() {
        /**
         * 获得 优秀学生的list
         */
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andIsExcellentEqualTo(1);
        List<Student> students = studentMapper.selectByExample(example);
        return students;
    }

    public List<StudentWithJobName> listExcellect() {
        List<StudentWithJobName> studentWithJobNames;
        studentWithJobNames = studentMapper.selectStudentWithJobName();
        return studentWithJobNames;
    }

}
