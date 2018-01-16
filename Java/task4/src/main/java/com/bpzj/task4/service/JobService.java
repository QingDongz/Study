package com.bpzj.task4.service;

import com.bpzj.task4.dao.JobMapper;
import com.bpzj.task4.domain.Job;
import com.bpzj.task4.domain.JobExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobMapper jobMapper;


    public List<Job> listAllJob() {
        JobExample example = new JobExample();
        JobExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<Job> jobs =  jobMapper.selectByExample(example);
        return jobs;
    }
}
