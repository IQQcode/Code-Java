package org.iqqcode.web.requestGeneralWay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-07 10:19
 * @Description:获取所有参数的请求名称
 */
@WebServlet("/PG_getParameterNames")
public class PG_getParameterNames extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> pn = request.getParameterNames();
        while (pn.hasMoreElements()) {
            String name = pn.nextElement();
            String value = request.getParameter(name);
            System.out.println(name + "----" + value);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
