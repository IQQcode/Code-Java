package com.Printstream;

import java.io.*;
import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-16 08:32
 * @Description:自己实现简单的打印流
 *
 * 除了String之外支持其他类型的输出
 * String ---> byte
 * boolean,int,double,float ---> String ---> byte
 */
class MyPrint {
    //最终调用的是write
    private OutputStream out;

    public MyPrint(OutputStream out) {
        this.out = out;
    }
    //对write()进行包装
    public void print(String str) throws IOException {
        out.write(str.getBytes());
    }
    public void println(String str) throws IOException {
        this.print(str + "\n");
    }
    public void print(double data) throws IOException {
        this.print(String.valueOf(data));
    }
    public void println(double data) throws IOException {
        this.print(data + "\n");
    }
    public void close() throws IOException {
        this.out.close();
    }

}

public class MyPrintStream {
    public static void main(String[] args) throws IOException {
        File file = new File(File.separator + "C:" + File.separator +
                "Users" + File.separator + "j2726" + File.separator + "Desktop" + File.separator +"javaIO.php");
        MyPrint myPrint = new MyPrint(new FileOutputStream(file));
        myPrint.println("Hello,IO");
        myPrint.println(3.1415926);
        myPrint.print("哈哈哈哈哈");
    }
}
