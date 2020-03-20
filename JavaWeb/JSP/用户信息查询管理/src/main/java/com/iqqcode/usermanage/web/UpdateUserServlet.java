package com.iqqcode.usermanage.web;

import com.iqqcode.usermanage.domain.User;
import com.iqqcode.usermanage.service.UserService;
import com.iqqcode.usermanage.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-23 15:10
 * @Description:信息修改
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        //获取数据
        Map<String,String[]> map = request.getParameterMap();
        //封装User
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用Service修改
        UserService service = new UserServiceImpl();
        service.updateUser(user);
        //跳转到查询所有用户
        response.sendRedirect(request.getContextPath() + "/userListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
