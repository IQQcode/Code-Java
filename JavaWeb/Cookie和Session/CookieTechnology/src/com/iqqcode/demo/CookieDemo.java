package com.iqqcode.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        response.setContentType("text/html;charset:utf-8");
        //1.获取所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有LastTime的cookie
        //2.遍历Cookie数组
        if (cookies!= null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是否为LastTime
                if (name.equals("LastTime")) {
                    flag = true;
                    //有该cookie,不是第一次访问
                    //获取当前字符串,重新获取cookie值,重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
                    String setdate = simpleDate.format(date);
                    //URL编码
                    setdate = URLEncoder.encode(setdate, "UTF-8");
                    cookie.setValue(setdate);
                    //设置cookie存活时间
                    cookie.setMaxAge(60*60);
                    response.addCookie(cookie);
                    //响应数据,获取cookie的value
                    String value = cookie.getValue();
                    //URL解码
                    value = URLDecoder.decode(value, "UTF-8");
                    response.getWriter().write("<h2>欢迎回来！您上次的访问时间是:" + value + "</h2>");
                    break;
                }
            }
        }
        if (flag == false || cookies == null || cookies.length == 0) {
            //没有,第一次访问
            Date date = new Date();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            String setdate = simpleDate.format(date);
            //URL编码
            setdate = URLEncoder.encode(setdate, "UTF-8");
            Cookie cookie = new Cookie("LastTime",setdate);
            //设置cookie存活时间
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
            response.getWriter().write("<h2>您好，欢迎您首次访问！</h2>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
