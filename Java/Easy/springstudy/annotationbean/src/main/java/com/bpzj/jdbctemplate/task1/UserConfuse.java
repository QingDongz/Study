package com.bpzj.jdbctemplate.task1;

import org.springframework.stereotype.Repository;

@Repository
public class UserConfuse implements User {


    @Override
    public void save() {
        System.out.println("用来混淆的User接口实现类，的save方法");
    }
}
