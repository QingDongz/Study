package com.bpzj.task4.controller;

import com.bpzj.task4.domain.ResponseMsg;
import com.bpzj.task4.domain.User;
import com.bpzj.task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignAndLogin {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg saveUser(User user) {
        if (userService.isUserNameExist(user.getUserName())) {
            return ResponseMsg.fail();
        } else {
            userService.insertUser(user);
            return ResponseMsg.success();
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg login(User user) {
        if (userService.checkLogin(user)) {
            return ResponseMsg.success();
        } else {
            return ResponseMsg.fail();
        }
    }

    @RequestMapping(value = "/checkName", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg checkUserName(@RequestParam("userName")String  userName) {
        if (userService.isUserNameExist(userName)) {
            return ResponseMsg.fail();
        } else {
            return ResponseMsg.success();
        }
    }
}
