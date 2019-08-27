package com.ByteStream;

import java.io.*;


public class InputStreamDemo {
    public static void main(String[] args) throws  Exception {
        //1.取得终端对象
        File file = new File("C:\\Users\\j2726\\Desktop\\Test_javaIO.txt");
        //保证文件存在
        if(!file.getParentFile().exists()) { //保证父目录文件存在
            file.getParentFile().mkdirs(); //创建多个父级目录
        }

        //2.取得相应输入流
        InputStream inputStream = new FileInputStream(file);

        //3.进行数据的读取
        byte[] data = new byte[1024];
        int len = inputStream.read(data);
        System.out.println(new String(data,0,len));

        //4.关闭流
        inputStream.close();
    }
}
