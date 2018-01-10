package com.demo.springmvc.service;

import com.demo.springmvc.dao.FruitsMapper;
import com.demo.springmvc.domain.Fruits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitsService {

    @Autowired
    FruitsMapper fruitsMapper;


    public List<Fruits> getAllFruits() {

        return fruitsMapper.listAll();
    }
}
