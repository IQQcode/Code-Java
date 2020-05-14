package com.iqqcode.servlet.characterstream;
import	java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-12 10:12
 * @Description:字符输出流
 */
@WebServlet("/OutputCharacterStream")
public class OutputCharacterStream extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码，防止中文乱码
        // (ISO-8859-1)设置流的默认编码为GBK
        response.setCharacterEncoding("UTF-8");

        //告诉浏览器，服务器发送的消息体数据的编码,建议浏览器使用该编码解码
        response.setHeader("content-type","text/html;charset=UTF-8");

        //简化形式设置编码
        response.setContentType("text/html;charset=UTF-8");

        //1.获取字符输出流
        PrintWriter out = response.getWriter();
        //2.输出数据
        out.write("<h1>你好 Response</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
