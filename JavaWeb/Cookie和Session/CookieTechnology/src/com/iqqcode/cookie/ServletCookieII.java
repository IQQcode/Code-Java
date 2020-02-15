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
 * @Description:
 */
@WebServlet("/ServletCookieII")
public class ServletCookieII extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //4.获取Cookie
        Cookie[] cs = request.getCookies();
        //5.获取数据,遍历Cookies
        if(cs != null) {
            for (Cookie c : cs) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name + ":" + value);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
