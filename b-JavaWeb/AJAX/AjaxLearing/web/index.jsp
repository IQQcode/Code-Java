<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JQ实现</title>
    <script src="js/jquery-3.4.1/jquery-3.4.1.min.js"></script>
    <script>
        function fun() {
            //使用$.ajax()发送异步请求
            $.ajax({
                url:"ajaxServlet", //请求路径
                type:"POST", //请求方式
                //data:"username=Tom&password=1234",//请求参数
                data:{"username":"Tom","password":"1234"},
                //响应成功后的回掉函数
                success:function (data) {
                    alert(data);
                },
                //请求响应出现错误回调函数
                error:function () {
                    alert("ERROR!")
                },
                dataType:"text" //接收到的响应数据格式
            });
        }
    </script>
</head>
<body>
<input type="button" value="发送异步请求" onclick="fun();">
<input type="text" placeholder="请求时能否输入">
</body>
</html>
