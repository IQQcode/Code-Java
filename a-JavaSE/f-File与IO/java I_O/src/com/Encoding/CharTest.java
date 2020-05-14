package com.Encoding;


import java.io.File;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-13 11:36
 * @Description:产生乱码
 */

// 1.编解码不一致
/*
public class CharTest {
    public static void main(String[] args) throws IOException {
       String fileName = new String("测试".getBytes(),"GBK");
        File file = new File("C:\\Users\\j2726\\Desktop\\" + fileName);
        file.createNewFile();
    }
}
*/


//2.数据不完整
public class CharTest {
    public static void main(String[] args) throws IOException {
        String str = "数据不完整导致乱码";
        byte[] array = str.getBytes();
        //UTF-8一个汉字为三个字节; GBK编码为两个字节
        System.out.println(new String(array,0,5));
    }
}