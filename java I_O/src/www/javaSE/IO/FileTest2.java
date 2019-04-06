package www.javaSE.IO;

import java.io.*;


/**
 * @字节与字符流
 */

/**
 * 1.字节的输出流
 */
/*
public class FileTest2 {
    public static void main(String[] args) throws Exception {
        //1.取得终端对象
        File file = new File("C:\\Users\\HASEE\\Desktop\\Test_javaIO.txt");
        //2.取得指定文件的输出流
        OutputStream outputStream = new FileOutputStream(file,true);
        //3.进行数据的输出
        String str = "Hellow java!";
        outputStream.write(str.getBytes());
        //追加内容
        //outputStream.write(str.getBytes(),7,5);
        //4.关闭流
        outputStream.close();
    }
}
*/

/**
 * 1.1自动关闭流
 *    AutoCloseble[自动关闭接口]，此接口必须使用try-catch代码块
 */
/*
class CloseTest implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("自动调用close方法");
    }
    public void fun() {
        System.out.println("普通方法");
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
        File file = new File("C:\\Users\\HASEE\\Desktop\\Test_javaIO.txt");
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
