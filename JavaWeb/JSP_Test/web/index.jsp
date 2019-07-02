<%--
  Created by IntelliJ IDEA.
  User: Mr.Q
  Date: 2019/7/2
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page info = "a hello word example" %>
<!DOCTYPE html>
<html>
  <head>
    <title>理解JSP原理</title>
  </head>
  <body>
  <center>
    <h1>
      <%
      int times = Integer.parseInt(request.getParameter("times"));
      for(int i =0; i< times; i++) {
        out.println("Hello,World! JSP!");
        out.println("<br>");
      }
      %>
    </h1>
  </center>
  </body>
</html>
