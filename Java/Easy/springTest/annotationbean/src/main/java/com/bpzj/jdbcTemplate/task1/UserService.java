package com.bpzj.jdbcTemplate.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    @Qualifier("userImpl")
    private User user;

    public void add() {
        System.out.println("UserService的add方法");
        user.save();
    }
}
