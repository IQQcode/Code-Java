<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>UserCheck</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script>
      $(function() {
        //给user绑定焦点blur
        $("#username").blur(function () {
          //获取username值
          var username = $(this).val();
          //发送ajax请求
          /**
           * 期望服务器响应回的数据格式
           *    {"userExist": true,"msg":"此用户名太受欢迎，请更换一个"}
           *    {"userExist": false,"msg":用户名可用"}
           */

          //(url,{请求参数}，回调函数）
          $.get("findUserServlet",{username:username},function (data) {
            //判断userExist的值
            var span = $("#s_user");
            if(data.userExist) {
              //用户存在
              span.css("color", "red");
              span.html(data.msg);
            }else {
              span.css("color", "blue");
              span.html(data.msg);
            }
          },"json");
        });
      });
    </script>
  </head>
  <body>
  <form>
    <input type="text" id="username" name="username" placeholder="请输入用户名">
    <span id="s_user"></span>
    <br>
    <input type="password" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="注册"><br>
  </form>
  </body>
</html>

