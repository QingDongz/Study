package com.demo.springmvc.Controller;

import com.demo.springmvc.domain.Fruits;
import com.demo.springmvc.service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloSpringMVC {

    @Autowired
    FruitsService fruitsService;

    @RequestMapping("/hello")
    public String hello() {
        System.out.printf("hello");
        return "index";
    }
}
