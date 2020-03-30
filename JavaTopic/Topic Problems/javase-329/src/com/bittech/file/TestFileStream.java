package com.bittech.file;

import java.io.*;

/**
 * Author: secondriver
 * Created: 2019/3/31
 */
public class TestFileStream {
    
    public static void code1() {
        //File -> path
        //1.准备文件  文件可以不存在，目录必须有
        File file = new File("D:" + File.separator + "test" + File.separator + "java7" + File.separator + "hello.txt");
        
        OutputStream out = null;
        try {
            //2.创建输出流对象
            out = new FileOutputStream(file);
            
            //3.输出内容
            //字节数组
            out.write("hello java!".getBytes());
            out.write("\n".getBytes());
            out.write("good".getBytes());
            out.write("\n".getBytes());
            
            //单字节
            //49->1
            //65->A
            //97->a
            out.write(49);
            
            //字节数组的部分内容
            out.write("\n".getBytes());
            out.write("hello".getBytes(), 1, 2);
            
            //4.刷新
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭流
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void code2() {
        //File -> path
        //1.准备文件  文件可以不存在，目录必须有
        File file = new File("D:" + File.separator + "test" + File.separator + "java7" + File.separator + "hello.txt");
        
        //2.创建输出流对象
        try (OutputStream out = new FileOutputStream(file)) {
            //3.输出内容
            //字节数组
            out.write("hello java!".getBytes());
            out.write("\n".getBytes());
            out.write("good".getBytes());
            out.write("\n".getBytes());
            
            //单字节
            //49->1
            //65->A
            //97->a
            out.write(49);
            
            //字节数组的部分内容
            out.write("\n".getBytes());
            out.write("hello".getBytes(), 1, 2);
            
            //4.刷新
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void code3() {
        //File -> path
        //1.准备文件  文件可以不存在，目录必须有
        File file = new File("D:" + File.separator + "test" + File.separator + "java7" + File.separator + "hello.txt");
        if (file.isFile() && file.exists()) {
            try (InputStream in = new FileInputStream(file)) {
                
                /*
                int b = in.read();
                System.out.println(b);
                byte[] buff = new byte[5];
                int len = in.read(buff,2,3);
                System.out.println("读取的长度：" + len);
                System.out.println("读取的内容：" + new String(buff));
                */
                //System.out.println(in.available());
                
                /*
                byte[] buff = new byte[in.available()];
                in.read(buff);
                System.out.println(new String(buff));
                */
                
                byte[] buff = new byte[3]; //4 => 3,3,3,2
                int len = -1;
                while ((len = in.read(buff)) != -1) {
                    //Hel
                    //loW
                    //orl
                    //d!l
                    System.out.print(new String(buff, 0, len));
                }
            } catch (IOException e) {
            
            }
        }
    }
    
    public static void code4() {
        //字符流
        //1.准备文件
        File file = new File("D:" + File.separator + "test" +
                File.separator + "java7" + File.separator + "writer.txt");
        try (Writer writer = new FileWriter(file)) {
            writer.append('A').append('B');
            writer.write("hello");
            writer.write("\n");
            writer.write("!!");
            writer.write("I老虎U！!");
            //ABhello
            //!!I老虎U！!
            writer.flush();
        } catch (IOException e) {
        
        }
    }
    
    public static void code6() {
        //字符流
        //1.准备文件
        File file = new File("D:" + File.separator + "test" +
                File.separator + "java7" + File.separator + "writer.txt");
        
        if (file.isFile() && file.exists()) {
            try (Reader reader = new FileReader(file)) {
                //1024 2048 2K 4K
               /*
                char[] buff = new char[1024];
                
                int len = reader.read(buff);
                System.out.println("读取的长度："+len);
                System.out.println("读取的内容：");
                System.out.println(new String(buff));
              */
                //字节流和字符流的输入流的读取，常用模式
                char[] buff = new char[5];
                int len = -1;
                while ((len = reader.read(buff)) != -1) {
                    System.out.print(new String(buff, 0, len));
                }
            } catch (IOException e) {
            
            }
        }
    }
    
    public static void main(String[] args) {
        
        /**
         * 字节流转换字符流
         *
         * byte  stream ----> char stream
         *
         * 编码  byte -> char
         * 解码  char ->  byte
         *
         * 编码 序列化技术   Java Object -> byte[]
         * 解码 反序列化技术 byte[]      -> Java Object
         */
        String file = "D:" + File.separator + "test" +
                File.separator + "java7" + File.separator + "writer.txt";
        try (OutputStream out = new FileOutputStream(file);
           
             //StreamEncoder byte -> char  charset字符编码
             //StreamDecoder
             OutputStreamWriter writer = new OutputStreamWriter(out);) {
           
            writer.write("hello world 比特科技！！！");
            writer.flush();
            
        } catch (IOException e) {
        
        }
        
        
    }
    
    
}
