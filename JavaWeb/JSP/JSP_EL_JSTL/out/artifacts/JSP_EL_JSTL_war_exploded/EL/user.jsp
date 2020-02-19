<%@ page import="com.iqqcode.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取User对象</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("Mr.Q");
        user.setAge(22);
        user.setBirthday(new Date());
        request.setAttribute("username", user);
    %>
    <h3>获取对象中的值</h3>

    <%--
    通过的是对象的属性来获取
    setter或 getter方法，去掉set或get，在将剩余部分，首字母变为小写
    setName --> Name --> name
    --%>

    <%--request域中名为username的键对应的对象,通过user对象来调用getName(),无此方法会报错--%>
    ${requestScope.username.name} <br>
    ${username.age} <br>
    ${username.birthday} <br>
    <%--日期格式化输出--%>
    ${username.birStr}

</body>
</html>
