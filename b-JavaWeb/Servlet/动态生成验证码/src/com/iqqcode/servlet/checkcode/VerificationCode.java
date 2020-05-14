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
        //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");
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

