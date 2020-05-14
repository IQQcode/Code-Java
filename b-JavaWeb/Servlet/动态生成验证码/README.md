## java动态实现验证码
【实现效果】

- 点击图片或者文字可以更换验证码
- 验证码随机生成，由大小写字母和数字组成
- 验证码字体颜色随机生成，字母角度有偏转
- 干扰线随机分布
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200213085536884.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200213090350206.png)
>**验证码的功能：** 防止恶意的表单注册

新建Web项目，目录结构：

<img src="https://imgkr.cn-bj.ufileos.com/b6136dec-ac0c-4f0c-986b-29613c83a001.png" width="50%">


<kbd>VerificationCode.java</kbd> 验证码功能实现
```java
package com.iqqcode.servlet.checkcode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-12 10:12
 * @Description:验证码生成
 */
@WebServlet("/VerificationCode")
public class VerificationCode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 120;
        int height = 50;

        //1.创建对象,验证码图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        //Graphics g = image.getGraphics();
        Graphics2D g = (Graphics2D) image.getGraphics();//画笔对象,2D来旋转验证码字母
        g.setColor(Color.WHITE);//设置画笔颜色
        g.fillRect(0, 0, width, height);

        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        //2.3生成验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random random = new Random();
        //改变字体
        g.setFont(new Font("宋体",Font.BOLD,35));

        //将验证码偏转并写到画布上
        for (int i = 1; i <= 4; i++) {
            int x = width/5 * i;
            int y = height/2;
            String msg = "";
            int index = random.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //获取正负30的角度
            int angle = random.nextInt(60) - 30;
            double radian = angle * Math.PI/180;
            //设置验证码中的字体颜色
            //g.setColor(Color.BLUE);
            int red = 0; int green = 0; int blue = 0;
            int codeY = 32;
            // 得到随机产生的验证码数字
            // 产生随机的颜色分量来构造颜色值,使输出的每位数字的颜色值都不同
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            // 用随机产生的颜色将验证码绘制到图像中
            g.setColor(new Color(red, green, blue));
            //写验证码
            g.rotate(radian, x, y);
            //把字母画在画布上
            //g.drawString(ch+"", x, y);
            g.drawString(String.valueOf(ch)+"", x, codeY);
            //把每次旋转的再旋转回来
            g.rotate(-radian, x, y);
            //每次向右移动20像素
            x += 15;
            msg += ch;
        }

        //2.4随机产生20条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(Color.MAGENTA);
        //随机生成坐标点
        for (int i = 0; i < 20; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1, x2, y1, y2);
        }

        //3.将图片输出到页面展示
        //将图片对象写入流中
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
```
--------------------------
<kbd>insex.jsp</kbd> 前台页面展示

**分析:**

- 点击超链接或者图片,需要换一张

- 给超链接和图片绑定单击事件

- 重新设置图片的src属性值

>生成的图片先要缓存在本地,每次请求是不会修改，所以验证码图片不会切换;
将图片路径后添加时间戳,通过错误的路径来欺骗服务器重新请求

```java
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>验证码</title>
  <script>
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
```

