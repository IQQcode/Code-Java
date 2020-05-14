<%--
  Created by IntelliJ IDEA.
  User: Mr.Q
  Date: 2020/2/15
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP</title>
  </head>
  <body>
  <%
    System.out.println("你好，JSP!");
    int i = 5;
  %>

  <%!
    int i = 10;
  %>

  <%=
    i
  %>
  <h2>Hello,JSP!</h2>
  </body>
</html>
