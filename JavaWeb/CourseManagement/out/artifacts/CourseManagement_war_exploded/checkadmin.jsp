<%--
  Created by IntelliJ IDEA.
  User: Mr.Q
  Date: 2019/7/4
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>check</title>
</head>
<body>
<% String adno=request.getParameter("adno");
    String adpassword = request.getParameter("adpassowrd");
    if(adno == null || adno.length() == 0 || adpassword==null ||adpassword.length()==0){
        request.getSession().setAttribute("error", "账号或密码错误");
        response.sendRedirect("admin.jsp");
    }else{
        if(!adno.equals("admin")||!adpassword.equals("admin")){
            request.getSession().setAttribute("error", "账号或密码错误");
            response.sendRedirect("admin.jsp");
        }else{
            request.getSession().setAttribute("error", "");
            response.sendRedirect("/    db_course_management/FindCourseServlet");
        }
    }
%>
</body>
</html>