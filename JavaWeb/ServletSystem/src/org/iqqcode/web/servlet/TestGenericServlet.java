package org.iqqcode.web.servlet;


import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-01-29 16:42
 * @Description:
 */
@WebServlet("/Demo")
public class TestGenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet类只是抽象出了service()...");
    }
}
