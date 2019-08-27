package com.ByteStream;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-13 08:51
 * @Description:字节的输出流OutputStream
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws Exception {
        //1.取得终端对象
        File file = new File("C:\\Users\\j2726\\Desktop\\Test_javaIO.txt");

        //保证文件存在
        if(!file.getParentFile().exists()) {//保证父目录文件存在
            file.getParentFile().mkdirs();  //创建多个父级目录
        }

        //2.取得指定文件的输出流

        //无论文件是否存在,都会自动创建文件;
        //若需要进行内容的追加而非覆盖,则需要添加 true
        OutputStream outputStream = new FileOutputStream(file,true);

        //3.进行数据的输出
        String str = "Hello java!";
        outputStream.write(str.getBytes());//将内容变为字节数组

        //追加内容
        String strAdd = "\nStick on!";
        outputStream.write(strAdd.getBytes());
        //4.关闭流
        outputStream.close();
    }
}

