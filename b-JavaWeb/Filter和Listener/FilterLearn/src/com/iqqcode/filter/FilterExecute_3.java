package com.iqqcode.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-28 13:18
 * @Description:Filter执行流程
 */
//@WebFilter("/*")
public class FilterExecute_3 implements Filter {
    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("1.FilterExecute请求执行");

        chain.doFilter(req, resp);

        //对response对象的响应消息增强
        System.out.println("3.FilterExecute响应数据");
    }

    @Override
    public void init(FilterConfig config) throws ServletException { }

}
