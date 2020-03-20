package com.iqqcode.usermanage.web;


import com.iqqcode.usermanage.domain.PageBean;
import com.iqqcode.usermanage.domain.User;
import com.iqqcode.usermanage.service.UserService;
import com.iqqcode.usermanage.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-25 09:57
 * @Description:分页查询
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 1.获取参数
        String currentPage = request.getParameter("currentPage"); //当前页码
        String rows = request.getParameter("rows"); //每页显示的条数

        if(currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

        //2.调用service查询
        UserService service = new UserServiceImpl();
        PageBean<User> pageBean = service.findUserByPage(currentPage, rows, condition);

        //3.将PageBean存入request域
        request.setAttribute("pageBean", pageBean);
        //将查询条件存入request，回显查询条件信息
        request.setAttribute("condition",condition);

        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
