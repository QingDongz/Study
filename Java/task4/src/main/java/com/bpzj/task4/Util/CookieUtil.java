package com.bpzj.task4.Util;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void creatCookie(
            HttpServletResponse response,
            String cookieName,
            String cookieValue,
            int cookieMaxAge) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(cookieMaxAge);
        // 指定uri
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void clearCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * 根据 cookie 的名称，获取 cookie 的值
     * @param request 请求端发送的请求，应该包括 cookie
     * @param cookieName 指定的cookie名称
     * @return cookie 的值
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        // 使用了webUtil这个类，里面集成了getCookie的方法
        Cookie cookie = WebUtils.getCookie(request, cookieName);

        if (cookie == null) {
            return null;
        }
        return cookie.getValue();
    }
}
