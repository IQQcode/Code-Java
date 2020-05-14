package org.iqqcode.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.iqqcode.dao.UserDao;
import org.iqqcode.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-09 15:16
 * @Description:
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("UTF-8");

        String verification = request.getParameter("checkCode");

        //2.获取所有请求参数
        Map<String,String[]> map = request.getParameterMap();

        //3.封装user对象
        User loginUser = new User();
        //3.1使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.验证码处理

        //4.1获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_Session = (String) session.getAttribute("checkCode_Session");
        //删除session中存储的验证码,防止重复使用
        session.removeAttribute("checkCode_Session");
        //4.2判断验证码是否正确
        if (checkCode_Session != null && checkCode_Session.equalsIgnoreCase(verification)) {
            //忽略大小写,比较字符串,验证码正确

            //判断用户名和密码是否一致
            //5.调用UserDao的login方法
            UserDao dao = new UserDao();
            User user = dao.login(loginUser);

            //6.判断user
            if (user == null) {
                //登录失败
                request.getRequestDispatcher("failServlet").forward(request, response);
            }else {
                //登陆成功,存储数据
                request.setAttribute("user", user);
                session.setAttribute("username", user.getUsername());
                //转发
                request.getRequestDispatcher("successServlet").forward(request, response);
            }
        }else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("CHECKCODE_Error", "验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
