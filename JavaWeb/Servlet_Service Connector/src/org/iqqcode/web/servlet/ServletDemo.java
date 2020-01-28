package org.iqqcode.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-01-28 10:20
 * @Description:Servlet入门Demno
 */
public class ServletDemo implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

