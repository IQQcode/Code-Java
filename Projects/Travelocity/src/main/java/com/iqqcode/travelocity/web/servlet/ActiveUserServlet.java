package com.iqqcode.travelocity.web.servlet;

import com.iqqcode.travelocity.service.UserService;
import com.iqqcode.travelocity.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-24 17:56
 * @Description:用户邮件激活
 */
@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取激活码
        String code = request.getParameter("code");
        if(code != null) {
            //2.调用service完成激活
            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);
            String msg = null;
            if (flag) {
                //激活成功
                msg = "激活成功，请<a href='login.html'>登录</a>";
            }else {
                //激活失败
                msg = "激活失败，请联系管理员!";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
