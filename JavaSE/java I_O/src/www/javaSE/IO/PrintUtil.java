package www.javaSE.IO;

import java.io.*;

/**
 * 实现打印流
 *
 *系统提供的打印流：
 *                字节打印流---PrintStream
 *                字符打印流---PrintWinter
 */

class PrintUtil_io {
    private OutputStream out;

    public PrintUtil_io(OutputStream out) {
        this.out = out;
    }

    //   byte --- byte[]  buf
    // char ->  String -> byte

    public void print(String str) {
        try {
            //getBytes()是将一个字符串转化为一个字节数组byte[]的方法
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(String str) {
        this.print(str + "\r\n");
    }

    //先变为字符串，再通过 this.print()变为字节数组
    public void print(int data) {
        this.print(String.valueOf(data));   //将 int变为 String(字符串)类型
    }

    public void println(double data) {
        this.print(data + "\r\n");
    }
    public void print(double data) {
        this.print(String.valueOf(data));
    }

    public void close() throws  Exception {
        this.out.close();
    }
}

public class PrintUtil {
    public static void main(String[] args) throws  Exception {
        //1.取得 File对象
        File file = new File("C:\\Users\\HASEE\\Desktop\\PrintUtiljavaIO.txt");
        //2.取得文件的输出流
            //系统提供的字节打印流 PrintStream
        PrintUtil_io printUtilIO = new PrintUtil_io(new FileOutputStream(file));
        //3.数据输出
        printUtilIO.print(20);
        printUtilIO.println("----内存流");
        printUtilIO.print(21.00);
        //4.关闭流
        printUtilIO.close();
    }
}



