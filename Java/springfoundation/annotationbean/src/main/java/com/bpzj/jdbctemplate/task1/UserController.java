package com.bpzj.jdbctemplate.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void execute() {
        System.out.println("UserController 的execute方法");
        userService.add();
    }
}
