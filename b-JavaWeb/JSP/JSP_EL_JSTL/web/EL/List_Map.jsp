<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iqqcode.domain.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取集合中的值</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("Mr.Q");

        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        list.add(user);
        request.setAttribute("list", list);

        Map map = new HashMap();
        map.put("id", "001");
        map.put("gender", "boy");
        map.put("user", user);
        request.setAttribute("map", map);
    %>
    <h3>获取List的值</h3>
    ${list} <br>
    ${list[0]} <br>
    ${list[1]} <br>
    ${list[10]} <br>
    ${list[2].name} <br>


    <h3>获取Map的值</h3>
    ${map.gender} <br>
    ${map["id"]} <br>
    ${map.user.name} <br>

</body>
</html>
