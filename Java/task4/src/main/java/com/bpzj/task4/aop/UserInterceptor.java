package com.bpzj.task4.aop;

import com.bpzj.task4.Util.CookieUtil;
import com.bpzj.task4.Util.JwtUtil;
import com.bpzj.task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import static com.bpzj.task4.service.Constant.COOKIE_NAME;
import static com.bpzj.task4.service.Constant.JWT_SECRET_KEY;

public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        // ===================优先用 session===================
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");

        // 已登录
        if (null != userName) {
            return true;
        }

        // ===================再判断 cookie===================
        // 从用户请求获取 cookie的值，这里是用户名经过 jwt加密后的 token 值
        String cookieValue = CookieUtil.getCookieValue(request, COOKIE_NAME);

        if (cookieValue == null) {
            returnFail(response);
            return false;
        }

        // 从 cookie 值中 解密得 用户名
        String decryptedName = JwtUtil.jwtDecrypt(cookieValue, JWT_SECRET_KEY);
        // 如果用户名为空
        if (null == decryptedName) {
            returnFail(response);
            //request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }

        // 如果 用户名 在 数据库 中 存在
        if (userService.isUserNameExist(decryptedName)) {
            // 将 用户名 加到session中，不退出浏览器时就只需判断session即可
            session.setAttribute("userName", decryptedName);
            return true;
        }

        returnFail(response);
        //request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }

    private void returnFail(HttpServletResponse response) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        //  输出流
        // PrintWriter是一种过滤流，也叫处理流。也就是能对字节流和字符流进行处理
        PrintWriter out =response.getWriter();
        out.append("{\"code\":\"600\"}");
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
