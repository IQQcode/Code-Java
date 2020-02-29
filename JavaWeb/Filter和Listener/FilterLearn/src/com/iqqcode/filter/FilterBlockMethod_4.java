package com.iqqcode.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-28 13:18
 * @Description:拦截方式配置--注解配置
 */

/**
 * @dispatcherTypes = DispatcherType.REQUEST
 * @testServlet1
 *      浏览器直接请求index.jsp资源时被拦截，过滤器被执行；dispatcherTypes默认为request请求
 *
 *@dispatcherTypes = DispatcherType.FORWARD
 *@testServlet2
 *      只有转发访问index.jsp时，该过滤器才会被执行
 *
 *@dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
 *      浏览器直接请求或者转发访问index.jsp时，该过滤器都会被执行
 */
//@WebFilter(value="/index.jsp", dispatcherTypes = DispatcherType.REQUEST) //过滤直接请求

//@WebFilter(value="/index.jsp", dispatcherTypes = DispatcherType.FORWARD) //过滤转发请求

//过滤 直接请求 和 转发请求
@WebFilter(value="/index.jsp", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})

public class FilterBlockMethod_4 implements Filter {
    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("FilterBlockMethod过滤器被执行");

        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException { }

}
