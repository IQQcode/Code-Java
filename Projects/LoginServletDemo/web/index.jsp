<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/font-awesome-4.7.0/css/font-awesome.css">

    <script>
      /*分析:
          点击超链接或者图片,需要换一张
          1.给超链接和图片绑定单击事件
          2.重新设置图片的src属性值

          PS:生成的图片先要缓存在本地,每次请求是不会修改，所以验证码图片不会切换;
          * 将图片路径后添加时间戳,通过错误的路径来欺骗服务器重新请求
       */

      window.onload = function () {
        //1.获取图片对象
        var img = document.getElementById("checkCode");
        //2.绑定图片单击事件
        img.onclick = function () {
          //加时间戳
          var date = new Date().getTime();
          //加时间戳，防止浏览器利用缓存
          img.src = "/LoginServletDemo/VerificationCode?" + date;
        }

        //绑定链接点击事件
        var ahref = document.getElementById("change");
        ahref.onclick = function () {
          var date = new Date().getTime();
          img.src = "/LoginServletDemo/VerificationCode?" + date;
        }
      }
    </script>

    <style>
      body {
        background: url('resources/images/name.png');
        /* 不重复 */
        background-repeat: no-repeat;
        /* 背景铺满 */
        background-size: 100% auto;
      }
      <%--控制div输出为红色--%>
      div {
        color: red;
      }
    </style>
  </head>
  <body>
  <form class="box" action="/LoginServletDemo/ServletLogin" method="POST">
    <div id="login-box">
      <h1>Login</h1>
      <!-- 输入框 -->
      <div class="form">
        <div class="item">
          <i class="fa fa-user-circle-o" aria-hidden="true"></i>
          <input type="text" name="username" placeholder="Username">
        </div>
        <div class="item">
          <i class="fa fa-key" aria-hidden="true"></i>
          <input type="password" name="password" placeholder="Password">
        </div>
        <div class="item">
          <i class="fa fa-check-circle-o" aria-hidden="true"></i>
          <input type="text" name="checkCode" placeholder="验证码">
        </div>
        <div><br>
          <img id="checkCode" src="/LoginServletDemo/VerificationCode" alt="checkCode">
          <a id="change" href="">看不清?换一张</a>
        </div>
      </div>
      <button>Login</button>
    </div>
  </form>

    <%--EL表达式--%>
    ${requestScope.CHECKCODE_Error}
    ${requestScope.Login_Error}

  <%--<div><%=request.getAttribute("CHECKCODE_Error")==null ? "" : request.getAttribute("CHECKCODE_Error")%></div>
  <div><%=request.getAttribute("Login_Error")==null ? "" : request.getAttribute("Login_Error")%></div>--%>

  </body>
</html>
