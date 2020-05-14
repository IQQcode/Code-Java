<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JQ实现</title>
    <script src="js/jquery-3.4.1/jquery-3.4.1.min.js"></script>
    <script>
        function fun() {
            //使用$.post()发送异步请求
            $.post("ajaxServlet",{username:"Tom",password:"1234"},function(data) {
                alert(data);
            },"text");
        }
    </script>
</head>
<body>
<input type="button" value="发送异步请求" onclick="fun();">
<input type="text" placeholder="请求时能否输入">
</body>
</html>
