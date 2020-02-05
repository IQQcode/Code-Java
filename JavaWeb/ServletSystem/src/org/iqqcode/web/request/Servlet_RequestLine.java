package org.iqqcode.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-05 15:38
 * @Description:Request对象获取请求行数据
 * 1.获取请求方式:GET---String getMethod()
 * 2.获取虚拟目录:/ServletDemo---String getContextPath()
 * 3.获取Servlet路径:/Demo---String getServletPath()
 * 4.获取get方式请求参数:username=Mr.Q---String getQuerystring()
 * 5.获取请求URI: /ServletDemo/Demo
 *                 String getRequestURI(): /ServletDemo/Demo
 *                 StringBuffer getRequestURL(): http://1ocalhost/ServletDemo/Demo
 * 6.获取协议及版本: HTTP/1.1---String getProtocol()
 * 7.获取客户机的IP地址---String getRemoteAddr()
 */

@WebServlet("/Servlet_RequestLine")
public class Servlet_RequestLine extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式:GET---String getMethod()
        String method = request.getMethod();
        System.out.println("获取请求方式GET: " + method);

        //2.获取虚拟目录:/ServletDemo---String getcontextPath()
        String contextPath = request.getContextPath();
        System.out.println("获取虚拟目录: " + contextPath);

        //3.获取Servlet路径:/Demo---String getServletPath()
        String servletPath = request.getServletPath();
        System.out.println("获取Servlet路径:" + request.getServletPath());

        //4.获取get方式请求参数:username=Mr.Q---String getQueryString()
        String queryString = request.getQueryString();
        System.out.println("获取get方式请求参数: " + queryString);

        //5.获取请求URI
        String requestURI = request.getRequestURI();
        System.out.println("getRequestURI(): " + requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("getRequestURL: " + requestURL);

        //6.获取协议及版本: HTTP/1.1---String getProtocol()
        String protocol = request.getProtocol();
        System.out.println("获取协议及版本: " + protocol);
        //7.获取客户机的IP地址---String getRemoteAddr()
        String remoteAddr = request.getRemoteAddr();
        System.out.println("获取客户机的IP地址: " + remoteAddr);
    }
}
