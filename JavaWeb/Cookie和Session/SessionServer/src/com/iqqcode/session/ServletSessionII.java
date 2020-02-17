package com.iqqcode.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-16 18:53
 * @Description:Session共享数据
 */
@WebServlet("/ServletSessionII")
public class ServletSessionII extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //3.获取Session
        HttpSession session = request.getSession();
        //4.获取数据
        Object obj = session.getAttribute("MSG");
        System.out.println(obj);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
