package com.iqqcode.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-16 18:53
 * @Description:Session共享数据
 */
@WebServlet("/ServletSessionIII")
public class ServletSessionIII extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //获取Session
        HttpSession session = request.getSession();
        //期望客户端关闭后,Session也能够相同
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        System.out.println(session);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
