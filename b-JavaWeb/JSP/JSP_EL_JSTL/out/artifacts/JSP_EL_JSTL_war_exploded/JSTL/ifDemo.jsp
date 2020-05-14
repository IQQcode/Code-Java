<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
    <%
        //判断request域中的一个list集合是否为空,如果不为null则显示遍力集合
        List list = new ArrayList();
        list.add("hello");
        request.setAttribute("list", list);
    %>
    <c:if test="${not empty list}">

    </c:if>
</body>
</html>
