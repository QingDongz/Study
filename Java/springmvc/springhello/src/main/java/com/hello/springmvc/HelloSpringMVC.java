package com.hello.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpringMVC {

    @RequestMapping("/hello")
    public String hello() {
        System.out.printf("hello");
        return "index";
    }
}
