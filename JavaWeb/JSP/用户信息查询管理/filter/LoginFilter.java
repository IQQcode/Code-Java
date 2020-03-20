package com.iqqcode.userquary.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-28 19:02
 * @Description:登录验证过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换为HttpServlet类型
        HttpServletRequest request = (HttpServletRequest) req;

        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源路径
        //要注意排除掉css/is/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/LoginServlet") || uri.contains("/VerificationCode") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/")) {
            //包含。用户想登录，放行
            chain.doFilter(req, resp);
        }else {
            //不包含，需要验证用户是否登录
            //3.从session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user != null) {
                //登陆了，放行
                chain.doFilter(req, resp);
            }else {
                //没登录，跳转到登录页面
                request.setAttribute("LOGIN_ERROR", "老铁，还没登录呀！");
                request.getRequestDispatcher("/index.jsp").forward(request, resp);
            }
        }
    }

    @Override
    public void destroy() { }
    @Override
    public void init(FilterConfig config) throws ServletException { }

}
