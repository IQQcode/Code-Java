package org.iqqcode.web.servlet;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-01-28 18:15
 * @Description:Servlet生命周期
 */
public class ServletMethods implements Servlet {
    /**
     * @init() 初始化方法
     * 在Servlet被创建时执行,只会执行有一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()...在Servlet被创建时执行,只会执行有一次");
    }

    /**
     * @getServletConfig() 获取ServletConfig对象
     * ServletConfig: Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * @service() 提供服务的方法
     * 每一次Servlet被访问时都会执行,执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()...每一次Servlet被访问时都会执行,执行多次");
    }

    /**
     * @getServletInfo 获取Servlet的信息、版本、作者等信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * @destroy() 销毁方法
     * 在服务器正常关闭时,执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy()...在服务器正常关闭时,执行一次");
    }
}
