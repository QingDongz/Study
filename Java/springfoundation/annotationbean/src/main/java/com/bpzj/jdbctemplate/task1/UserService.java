package com.bpzj.jdbctemplate.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 装配了一个user，使用@Qualifier指定装配User的名称，要和UserImpl的名称一致
    @Autowired
    @Qualifier("userImpl")
    private User user;

    public void add() {
        System.out.println("UserService的add方法");
        user.save();
    }
}
