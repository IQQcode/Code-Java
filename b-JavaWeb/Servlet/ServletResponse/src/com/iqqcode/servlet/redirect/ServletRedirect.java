package com.iqqcode.servlet.redirect;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-11 20:57
 * @Description:重定向
 * 访问ServletRedirect会自动跳转到ServletRedirect_Test
 */
@WebServlet("/ServletRedirect")
public class ServletRedirect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println("访问ServletRedirect...");
        //1.设置状态码为302
        //response.setStatus(302);
        //2.设置头为location
        //response.setHeader("location","/ServletRedirect_Test");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();

        //简单的重定向方法
        response.sendRedirect(contextPath + "ServletRedirect_Test");

        //共享数据测试
        request.setAttribute("msg","Test response");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
