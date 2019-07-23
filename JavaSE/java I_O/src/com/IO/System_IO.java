package com.IO;

import  java.io.*;
import  java.io.IOException;
import  java.util.Scanner;

/**
 *  使用System.out为 OutputStream实例化
 */
/*
public class System_IO {
    public static void main(String[] args) throws  Exception {
        OutputStream out = System.out ;
        out.write("使用System.out为OutputStream实例化".getBytes());
    }
}
*/

/**
 * 系统输入：
 * System.in 是InputStream的直接对象
 */
/*
public class System_IO {
    public static void main(String[] args) throws  Exception {
        InputStream in = System.in;
        System.out.println("亲输入内容: ");
        //字节数组存放输入的字符串
        byte[] data = new byte[1024];
        int len = 0;
        len = in.read(data);
        System.out.println("输入内容为：" + new String(data,0,len));
    }
}
*/

/**
 * 自定义分隔符为输入的结束标志
 */

public class System_IO {
    public static void main(String[] args) throws  Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入内容：");
        input.useDelimiter("-");
        if(input.hasNext()) {
            System.out.println("输入内容为：" + input.next());
        }
    }
}