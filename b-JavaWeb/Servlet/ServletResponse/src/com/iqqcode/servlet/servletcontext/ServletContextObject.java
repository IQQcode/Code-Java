package com.iqqcode.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-13 12:15
 * @Description:ServletContext对象获取
 * ServletContext对原获取:
 * 1.通过request对象获取 request.getServletContext();
 * 2.通过HttpServlet获取 this.getServletContext();
 */
@WebServlet("/ServletContextObject")
public class ServletContextObject extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过request对象获取
        ServletContext context1 = request.getServletContext();
        System.out.println(context1);
        //通过HttpServlet获取
        ServletContext context2 = this.getServletContext();
        System.out.println(context2);
        System.out.println(context1.equals(context2));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
