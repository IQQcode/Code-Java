<%--
  Created by IntelliJ IDEA.
  User: Mr.Q
  Date: 2019/7/4
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
</head>
<body style="text-align: center;">
<br><br>
<h3>管理员登录</h3>
<%
    String error = (String)session.getAttribute("error");
    if(error!=null&&error.length()!=0){
        out.println(error);
    }

%>
<form action="checkadmin.jsp" method="post">
    账号：<input type="text" name="adno">
    <br><br>
    密码：<input type="password" name="adpassowrd">
    <br><br>
    <input type="submit" value="登录" name="submit">
    <a href="../index.jsp">返回</a>
</form>
</body>
</html>