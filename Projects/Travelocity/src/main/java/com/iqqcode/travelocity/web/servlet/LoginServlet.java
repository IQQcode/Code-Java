package com.iqqcode.travelocity.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iqqcode.travelocity.domain.ResultInfo;
import com.iqqcode.travelocity.domain.User;
import com.iqqcode.travelocity.service.UserService;
import com.iqqcode.travelocity.service.impl.UserServiceImpl;
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
 * @Date: 2020-03-25 10:47
 * @Description:用户登录
 * 1. 获取用户信息
 * 2. 调用service查询
 * 3. 判断用户是否存在
 * 4. 判断用户是否激活
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();
        User user=  new User();
        //2.封装User对象
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用Service查询
        UserService service = new UserServiceImpl();
        User u = service.login(user);

        //4.判断用户对象是否为null
        ResultInfo info = new ResultInfo();
        if(u == null) {
            //用户名或密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        //5.判断用户是否激活
        if(u != null && !"Y".equals(u.getStatus())) {
            //用户存在但是尚未激活
            info.setFlag(false);
            info.setErrorMsg("账户未激活，请您激活！");
        }
        //6.判断是否登录成功
        if (u != null && "Y".equals(u.getStatus())) {
            //登录成功标记
            request.getSession().setAttribute("user", u);
            //登录成功
            info.setFlag(true);
        }
        //响应数据
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream() , info);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
