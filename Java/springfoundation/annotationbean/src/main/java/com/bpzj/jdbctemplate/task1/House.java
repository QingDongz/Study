package com.bpzj.jdbctemplate.task1;

import org.springframework.stereotype.Component;

@Component ("house")
public class House {

    public void express() {
        System.out.println("house的save方法");
    }

    public House() {
    }
}
