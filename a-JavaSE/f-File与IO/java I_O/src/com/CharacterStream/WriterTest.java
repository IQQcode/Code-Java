package com.CharacterStream;
import java.io.*;


import java.io.Writer;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-13 11:13
 * @Description:字符输出流Writer
 */
public class WriterTest {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\j2726\\Desktop\\Test_javaIO.txt");
        Writer writer = new FileWriter(file);
        writer.write("字符输出流Writer\n");
        writer.close();
        //writer.flush();  //不关闭流，强制刷新缓存区输出数据
    }
}
