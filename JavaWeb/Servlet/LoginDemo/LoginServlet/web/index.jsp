<%--
  Created by IntelliJ IDEA.
  User: Mr.Q
  Date: 2020/2/9
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
  <form class="box" action="/LoginServletDemo/ServletLogin" method="POST">
    <h1>Login</h1>
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" name="" value="Login">
  </form>
  </body>
</html>
