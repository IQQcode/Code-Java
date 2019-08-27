package com.ByteStream;
import java.io.*;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-13 10:09
 * @Description: A文件中的内容拷贝到B文件
 * 向IDEA传递路径参数
 */
public class CopyFileSource {
    public static void main(String[] args) throws IOException {

        //源文件
        File sourceFile = new File("C:\\Users\\j2726\\Desktop\\0.jpg");
        //目标文件
        File targetFile = new File("G:\\javaTest\\test.jpg");
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(targetFile);
        //文件拷贝
        copyFileSource(in,out);
    }
    private static void copyFileSource(InputStream in, OutputStream out) throws IOException {
        System.out.println("文件拷贝开始...");
        long start = System.currentTimeMillis();
        int len = 0;
        //缓存区边读边写
        byte [] data = new byte [4096];
        //返回 -1<终止标记>此时数据已经读取完毕
        while ((len = in.read(data)) != -1) {
            out.write(data, 0, len);
        }
        long end = System.currentTimeMillis();
        System.out.println("文件拷贝结束！\n共耗时" + (end - start) + "ms");
    }
}
