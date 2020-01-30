package org.iqqcode.web.servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-01-29 11:50
 * @Description:注解配置
 */

@WebServlet(urlPatterns="/AnnotationConfigDemo")
public class ServletAnnotationConfig implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet4.0 Annotation Config...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
