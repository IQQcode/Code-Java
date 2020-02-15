package com.iqqcode.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-15 20:20
 * @Description:记录上一次访问时间
 * 有:不是第一次访问
 * 	  -响应数据：欢迎回来，您上次访问时间为：2020年2月15日20:16:20
 * 	  -写回 Cookie：LastTime，更新时间
 * 没有:是第一次访问
 * 	  -响应数据：您好，欢迎您首次访问！
 * 	  -写回 Cookie：LastTime，更新时间
 */
@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应消息体的数据格式及编码
        response.setContentType("");
        //1.获取所有Cookie
        Cookie[] cookie = request.getCookies();
        //2.遍历Cookie数组
        if (cookie!= null && cookie.length > 0) {
            for (Cookie cookie1 : cookie) {
                //3.获取cookie的名称
                String name = cookie1.getName();
                //4.判断名称是否为LastTime
                if (name.equals("LastTime")) {
                    //有该cookie,不是第一次访问
                    //响应数据,获取cookie的value
                    String value = cookie1.getValue();
                    response.getWriter().write("<h2>欢迎回来！您上次的访问时间是:" + value + "<h2>");
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
