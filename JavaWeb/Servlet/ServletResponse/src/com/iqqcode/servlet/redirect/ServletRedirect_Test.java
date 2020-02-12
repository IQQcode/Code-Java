package com.iqqcode.servlet.redirect;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-11 20:57
 * @Description:重定向_Test
 */
@WebServlet("/ServletRedirect_Test")
public class ServletRedirect_Test extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println("访问ServletRedirect_Test...");

        //共享数据测试
        Object object = request.getAttribute("msg");
        System.out.println(object);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
