<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basic Grammar</title>
</head>
<body>
    \${3 > 4} ${3 > 4}
    <hr>
    <h3>获取域中的数据值</h3>
    <%
        //在域中存储数据
        request.setAttribute("name", "Mr.Q");
        session.setAttribute("age", "23");
        session.setAttribute("name", "IQQCode");
    %>
    <%--${name}依次从上面四个域中寻找名为name的键(域的范围从小到大)--%>
    ${name} <br>

    ${requestScope.name} <br>
    ${sessionScope.age} <br>

    <hr>
    <h3>empty运算符</h3>
    <%
        String str1 = "";//空字符串,长度为0
        String str2 = "ADB";
        request.setAttribute("str1", str1);
        request.setAttribute("str2", str2);
    %>
    ${empty str1}
    ${empty str2}

</body>
</html>
