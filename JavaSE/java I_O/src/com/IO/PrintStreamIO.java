package com.IO;

import  java.io.*;

/**
 * 内存操作流---小写字符串转为大写
 *
 * 内存流---看做为临时文件
 */


public class PrintStreamIO {
    public static void main(String[] args) throws Exception {
        String str = "hellow world!";
        //1.取得终端对象以及输入输出流
        ByteArrayInputStream byteArrayInputStream =
                new ByteArrayInputStream(str.getBytes());//多个输入流，需要传参
        //输出流就一个内存，不需要传值
        ByteArrayOutputStream byteArrayOutputStream =
                new ByteArrayOutputStream();
        //2.数据对象的读取与写入
        int len = 0;
        while ((len = byteArrayInputStream.read()) != -1) {
            byteArrayOutputStream.write(Character.toUpperCase(len));
        }
        //直接输出内存内容
        System.out.println(byteArrayOutputStream);
        //3.关闭流
        byteArrayInputStream.close();
        byteArrayOutputStream.close();
    }
}



