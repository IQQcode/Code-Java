<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>验证码</title>
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
        img.src = "/ServletResponse/VerificationCode?" + date;
      }

      //绑定链接点击事件
      var ahref = document.getElementById("change");
      ahref.onclick = function () {
        var date = new Date().getTime();
        img.src = "/ServletResponse/VerificationCode?" + date;
      }
    }
  </script>
</head>
<body>
<h2>验证码动态实现</h2>
<img id="checkCode" src="/ServletResponse/VerificationCode">
<a id="change" href="">看不清?换一张</a>
</body>
</html>
