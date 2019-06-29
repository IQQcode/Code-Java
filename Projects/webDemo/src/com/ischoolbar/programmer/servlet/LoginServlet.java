package com.ischoolbar.programmer.servlet;

import com.ischoolbar.programmer.model.Admin;
import com.ischoolbar.programmer.sql.AdminSQL;
import com.ischoolbar.programmer.util.StringUtil;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mr.Q
 *登录验证servlet
 *
 * 验证码的判断逻辑
 *      获取到用户输入的验证码，和 Session中的对比
 */
public class LoginServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -5870852067427524781L;

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String vcode = request.getParameter("vcode");
        String name = request.getParameter("account");
        String password = request.getParameter("password");
        int type = Integer.parseInt(request.getParameter("type"));
        String loginCpacha = request.getSession().getAttribute("loginCapcha").toString();
        if(StringUtil.isEmpty(vcode)){
            response.getWriter().write("vcodeError");
            return;
        }
        if(!vcode.toUpperCase().equals(loginCpacha.toUpperCase())){
            response.getWriter().write("vcodeError");
            return;
        }

        //验证码验证通过，对比用户名密码是否正确
        switch (type) {
            case 1: {    // 1为管理员
                AdminSQL adminSQL = new AdminSQL();
                Admin admin = adminSQL.login(name,password);
                if(admin == null) { //对比用户信息为空，没找到
                    response.getWriter().write("loginError");
                    return;
                }
                HttpSession session = request.getSession();
                session.setAttribute("user",admin);
                session.setAttribute("userType",type);
                response.getWriter().write("admin");
                break;
            }
            case 2: {

            }

            default :
                break;
        }


        //用户名密码正确，
    }
}
