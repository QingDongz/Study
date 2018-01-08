package com.bpzj.web.service;

import com.bpzj.web.dao.StudentMapper;
import com.bpzj.web.domain.Student;
import com.bpzj.web.domain.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public void saveStudent(Student student) {
        studentMapper.insertSelective(student);
    }

    public List<Student> getAll() {
        return studentMapper.selectByExample(null);
    }

    public Student getStudentById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public void updateStudent(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    public void deleteById(Long id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Long> str_ids) {

        // 创建一个 条件
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(str_ids);
        // deleteByExample 按照自定义条件删除
        studentMapper.deleteByExample(example);
    }
}
