<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <%
    //1.获取所有Cookie
    Cookie[] cookies = request.getCookies();
    boolean flag = false;//没有LastTime的cookie
    //2.遍历Cookie数组
    if (cookies!= null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            //3.获取cookie的名称
            String name = cookie.getName();
            //4.判断名称是否为LastTime
            if (name.equals("LastTime")) {
                flag = true;
                //有该cookie,不是第一次访问
                //获取当前字符串,重新获取cookie值,重新发送cookie
                Date date = new Date();
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
                String setdate = simpleDate.format(date);
                //URL编码
                setdate = URLEncoder.encode(setdate, "UTF-8");
                cookie.setValue(setdate);
                //设置cookie存活时间
                cookie.setMaxAge(60*60);
                response.addCookie(cookie);
                //响应数据,获取cookie的value
                String value = cookie.getValue();
                //URL解码
                value = URLDecoder.decode(value, "UTF-8");
    %>

    <h2>欢迎回来!&nbsp;您上次的访问时间是:&nbsp;<%=value%></h2>

    <%
                break;
            }
        }
    }
    if (flag == false || cookies == null || cookies.length == 0) {
        //没有,第一次访问
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String setdate = simpleDate.format(date);
        //URL编码
        setdate = URLEncoder.encode(setdate, "UTF-8");
        Cookie cookie = new Cookie("LastTime",setdate);
        //设置cookie存活时间
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    %>

    <h2>您好，欢迎您首次访问！</h2>

    <%
    }
    %>

</body>
</html>
