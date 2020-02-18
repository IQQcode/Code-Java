package org.iqqcode.servlet;

import org.iqqcode.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-09 16:36
 * @Description:
 */
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //页面设置编码
        response.setContentType("text/html;charset=UTF-8");

        //获取request域中共享的user对象
        User user= (User)request.getAttribute("user");

        if(user != null) {
            //输出
            //response.getWriter().write("登陆成功!" + user.getUsername() +"欢迎您！");

            //重定向到success.jsp
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
