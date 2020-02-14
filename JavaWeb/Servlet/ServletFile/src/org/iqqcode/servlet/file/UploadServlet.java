package org.iqqcode.servlet.file;

import java.io.*;
import java.util.List;
import java.util.UUID;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        try {
            //创建工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            File file = new File("/File");
            if (!file.exists()) {
                file.mkdir();
            }

            //设置文件的缓存路径
            factory.setRepository(file);

            //创建fileupload组件
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setHeaderEncoding("GBK");

            //解析request
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            PrintWriter write = response.getWriter();
            //遍历集合
            for (FileItem fileItem : fileItems) {
                //判断是否为普通字段
                if (fileItem.isFormField()) {
                    //获取字段名和字段值
                    String name=fileItem.getFieldName();
                    String value=fileItem.getString("GBK");
                    write.println("上传者：" + value);
                } else {
                    //上传文件路径
                    String filename = fileItem.getName();
                    write.println("文件来源：" + filename);
                    //截取文件名
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    write.println("成功上传的文件：" + filename);
                    //文件名唯一
                    filename = UUID.randomUUID().toString() + "_" + filename;
                    //在服务器创建同名文件
                    String webPath = "/File/";
                    String filepath = getServletContext().getRealPath(webPath+filename);
                    //创建文件
                    File fileNew = new File(filepath);
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                    //获得上传文件流
                    InputStream in = fileItem.getInputStream();
                    //获得写入文件流
                    OutputStream out = new FileOutputStream(fileNew);
                    //设置缓存区
                    byte[] buffer = new byte[1024 * 8];
                    int len ;
                    while((len = in.read(buffer)) > 0){
                        out.write(buffer, 0, len);
                    }
                    //关闭流
                    in.close();
                    out.close();
                    //删除临时文件
                    fileItem.delete();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
}

