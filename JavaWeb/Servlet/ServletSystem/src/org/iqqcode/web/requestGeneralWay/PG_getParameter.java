package org.iqqcode.web.requestGeneralWay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-07 10:19
 * @Description:
 */
@WebServlet("/PG_Parameter")
public class PG_getParameter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post 获取请求参数
        //根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println("post----" + username);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String username = request.getParameter("username");
        //System.out.println("post----" + username);

        this.doPost(request,response);
    }
}
