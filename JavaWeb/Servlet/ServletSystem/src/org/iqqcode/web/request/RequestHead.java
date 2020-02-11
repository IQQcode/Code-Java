package org.iqqcode.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-05 16:29
 * @Description:Request对象获取请求头数据
 */
@WebServlet("/Servlet_RequestHead")
public class RequestHead extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //2.遍历
        while(headerNames.hasMoreElements()) {
             String name = headerNames.nextElement();
             String value = request.getHeader(name);
             System.out.println(name + "----" + value);
        }

        //获取请求头数据user-agent
        //String agent = request.getHeader("user-agent");
        //if(agent.contains("Chrome")) { } else { }

        //获取请求头数据referer
        //String agent = request.getHeader("referer");
    }
}
