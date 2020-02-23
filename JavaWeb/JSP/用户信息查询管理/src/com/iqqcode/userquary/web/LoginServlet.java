package com.iqqcode.userquary.web;

import com.iqqcode.userquary.domain.User;
import com.iqqcode.userquary.service.UserService;
import com.iqqcode.userquary.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import	java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-22 16:22
 * @Description:用户登录页面
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("UTF-8");
        //2.获取用户填写验证码
        String verification = request.getParameter("verifycode");
        //3.验证码处理
        //3.1获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_Session =(String) session.getAttribute("checkCode_Session");
        //删除session中存储的验证码,防止重复使用
        session.removeAttribute("checkCode_Session");
        //4.2判断验证码是否正确
        if(!checkCode_Session.equalsIgnoreCase(verification)) {
            //验证码不正确
            //提示信息
            request.setAttribute("LOGIN_ERROR", "验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        //5.获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        //6.封装Use对象
        User user = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //7.调用UserService查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);
        //判断登录是否成功
        if(loginUser != null) {
            //将用户存入session
            session.setAttribute("user", loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath() + "/default.jsp");
        }else {
            //登陆失败，提示信息
            request.setAttribute("LOGIN_ERROR", "用户名或密码错误！");
            //请求转发到登录页面
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
