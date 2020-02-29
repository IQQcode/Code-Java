package com.iqqcode.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-28 12:21
 * @Description:过滤器快速入门
 */
//@WebFilter("/*") //访问所有资源前，都会执行该过滤器
public class FilterDemo_1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo被执行...");
        //是否放行
        //放行
        //filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
