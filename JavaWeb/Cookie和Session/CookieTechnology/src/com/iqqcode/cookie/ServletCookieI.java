package com.iqqcode.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-15 15:30
 * @Description:Cookie快速入门
 */
@WebServlet("/ServletCookieI")
public class ServletCookieI extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("MSG","Hello");
        //2.设置cookie存活时间
        cookie.setMaxAge(30);//将cookie存储到硬盘,30s后自动删除
        //3.发送Cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
