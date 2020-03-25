package com.iqqcode.travelocity.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-25 14:50
 * @Description:退出登录
 * 访问servlet,将session销毁
 * 跳转到登录页面
 */
@WebServlet("/exitServlet")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //销毁session
        request.getSession().invalidate();
        //重定向跳转页面
        response.sendRedirect(request.getContextPath() + "/login.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
