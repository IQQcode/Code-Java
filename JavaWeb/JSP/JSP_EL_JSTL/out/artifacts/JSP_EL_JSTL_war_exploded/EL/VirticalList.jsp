<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态获取虚拟目录</title>
</head>
<body>
    <h3>在JSP页面隐式对象动态获取虚拟目录</h3>
    ${pageContext.request} <br>
    ${pageContext.request.contextPath} <br>

    <%--等价于 response.sendRedirect(request.getContextPath() + "");--%>
</body>
</html>
