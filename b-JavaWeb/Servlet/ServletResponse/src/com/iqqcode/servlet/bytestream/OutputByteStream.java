package com.iqqcode.servlet.bytestream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-12 10:12
 * @Description:字节输出流
 */
@WebServlet("/OutputByteStream")
public class OutputByteStream extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置编码，防止中文乱码
        response.setContentType("text/html;charset=UTF-8");
        //1.获取字节输出流
        ServletOutputStream out = response.getOutputStream();
        //2.输出数据
        out.write("<h1>你好 Response</h1>".getBytes());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

