package org.iqqcode.servlet.file;

import org.iqqcode.servlet.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-13 16:56
 * @Description:文件下载
 */
@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1.获取请求参数,文件名称
        String fileName = request.getParameter("fileName");

        //2.使用字节输入流加载文件进内存

        //2.1找到文件服务器路径
         ServletContext servletContext = this.getServletContext();
         String realPath = servletContext.getRealPath("/img/" + fileName);

         //2.2用字节流将文件读入内存
        FileInputStream file = new FileInputStream(realPath);

        //3.设置response响应头

        //3.1设置响应头类型:content-type
        //获取文件MIME类型
        String fileType = servletContext.getMimeType(fileName);
        response.setHeader("content-type",fileType);

        //3.2设置响应头打开方式:content-disposition

        //解决中文文件名问题

        //I.获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //II.使用工具类方法编码文件名
        fileName = DownLoadUtils.getFileName(agent, fileName);

        response.setHeader("content-disposition","attachment;fileName" + fileName);

        //4.将内存中的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        //设置缓存区
        byte[] buffer = new byte[1024 * 8];
        int len = 0;
        while ((len = file.read(buffer)) != -1) {
            sos.write(buffer, 0, len);
        }

        //关闭流
        file.close();
        sos.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
