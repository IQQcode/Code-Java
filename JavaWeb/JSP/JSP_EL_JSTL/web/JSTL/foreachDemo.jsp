<%@ page import="java.util.List" %>
<%@ page import="com.iqqcode.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>foreach标签</title>
</head>
<body>
    <%--@完成重复操作
        属性
        - begin:开始值
        - end:结束值
        - var:临时变量
        - step:步长
        - varStatus:循环状态对象
            - index:容器中元素的索引(从0开始)
            - count:计数器,记录循环次数(从1开始)
     --%>
    <c:forEach begin="0" end="9" var="i" step="1">
        ${i} <br>
    </c:forEach>

    <br><hr><br>

    <%--@遍历容器List
        属性:
         - items：容器对象
         - var：容器中元素的临时变量
         - varstatus：循环状态对象
	        - index：容器中元素的索引，从0开始
	        - count：循环次数，从1开始
    --%>
    <%
        User user = new User();
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        list.add(user);
        request.setAttribute("list", list);
    %>
    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str}
    </c:forEach>
</body>
</html>
