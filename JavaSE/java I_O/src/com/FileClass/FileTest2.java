package com.FileClass;

import java.io.*;


/**
 * @字节与字符流
 */

/**
 * 1.字节的输出流OutpuutStream ---> 程序中的内容读取到指定文件
 */

/*
public class FileTest2 {
    public static void main(String[] args) throws Exception {
        //1.取得终端对象
        File file = new File("C:\\Users\\j2726\\Desktop\\Test_javaIO.txt");

        //保证文件存在
        if(!file.getParentFile().exists()) {//保证父目录文件存在
            file.getParentFile().mkdirs();//创建多个父级目录
        }

        //2.取得指定文件的输出流
        //无论文件是否存在，都会自动创建文件; 若要追加文件，则需要添加true
        OutputStream outputStream = new FileOutputStream(file,true);
        //3.进行数据的输出
        String str = "Hellow java!";
        outputStream.write(str.getBytes());//将内容变为字节数组

        //追加内容
        String strAdd = "\nStick on!";
        outputStream.write(strAdd.getBytes());
        //4.关闭流
        outputStream.close();
    }
}
*/


/**
 * 1.1自动关闭流 --> JDK1.7
 *    AutoCloseble[自动关闭接口]，
 *                             此接口必须使用try-catch代码块才会自动调用
 */


/*
class CloseTest implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("自动调用close方法");
    }
    public void fun() {
        System.out.println("显示调用");
    }
}

public  class FileTest2 {
    public static void main(String[] args) {
        try(CloseTest closeTest = new CloseTest()) {
            closeTest.fun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/



public class FileTest2 {
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
