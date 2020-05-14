package com.Memorystream;

import java.io.*;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-16 07:53
 * @Description:
 */
public class LowerToUpper {
    public static void main(String[] args) throws IOException {
        String str = "iqqcode";
        //使用指定的字符集将字符串编码为byte序列，并将结果存储到一个新的byte数组中
        InputStream in = new ByteArrayInputStream(str.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        int len = 0;
        while ((len = in.read()) != -1) {
            out.write(Character.toUpperCase(len));
        }
        System.out.println(out);
        in.close();
        out.close();
    }
}
