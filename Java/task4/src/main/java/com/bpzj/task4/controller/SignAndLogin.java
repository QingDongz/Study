package com.bpzj.task4.controller;

import com.bpzj.task4.Util.SHA256Util;
import com.bpzj.task4.domain.ResponseMsg;
import com.bpzj.task4.domain.User;
import com.bpzj.task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SignAndLogin {
    @Autowired
    private UserService userService;

    /**
     * 注册 处理
     * @param user
     * @return
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg saveUser(User user) {
        if (userService.isUserNameExist(user.getUserName())) {
            return ResponseMsg.fail();
        } else {
            int result = userService.insertUser(user);
            System.out.println("result is"+result);
            return ResponseMsg.success();
        }
    }

    /**
     * 登录 处理
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg login(HttpServletResponse response, HttpSession session, User user) {
        if (userService.checkLogin(user)) {
            String code = SHA256Util.getSHA256Str(SHA256Util.getSalt()).toUpperCase();
            Cookie cookie = new Cookie("key", code);
            cookie.setMaxAge(60*60*24);
            cookie.setPath("/");
            response.addCookie(cookie);
            session.setAttribute("key",code);
            session.setMaxInactiveInterval(60*60*24);
            return ResponseMsg.success();
        } else {
            return ResponseMsg.fail();
        }
    }


    public ResponseMsg signOut() {
        return ResponseMsg.success();
    }

    /**
     * 检验用户名，是否和数据库中的重复
     * @param userName 用户输入的 userName
     * @return 自定义的格式，使用 Jackson 转为 json 字符
     */
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
