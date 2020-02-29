package com.iqqcode.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-28 12:21
 * @Description:过滤器web.xml配置
 */
public class Filter_config_2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter_Config被执行...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
