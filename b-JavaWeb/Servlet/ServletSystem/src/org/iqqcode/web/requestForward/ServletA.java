package org.iqqcode.web.requestForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-08 09:25
 * @Description:请求转发,共享数据
 */
@WebServlet("/ServletA")
public class ServletA extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet DemoA 被访问了...");
        //转发到ServletB资源

        //共享数据,存储数据到request域中
        request.setAttribute("name","requestForward");
        //RequestDispatcher reader = request.getRequestDispatcher("/ServletB");
        //reader.forward(request, response);
        request.getRequestDispatcher("/ServletB").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
