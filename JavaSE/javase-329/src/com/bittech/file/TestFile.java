package com.bittech.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 1. 操作系统中的文件系统 目录和文件 -> java.io.File
 * 2. 创建，删除，修改，查询
 * 3. 科普：
 *       Windows: 文件名不区分大小写；
 *       File.separator \(反斜杠) "\\" ；
 *       File.pathSeparator 路径分隔符 （;）
 *       Linux  : 文件名是区分大小写；
 *       File.separator /(正斜杠)      ；
 *       File.pathSeparator 路径分隔符  (:)
 * 4. File对象中
 *      mkdir 创建当前目录（如果父目录不存在创建失败）
 *      mkdirs 创建当前目录，如果父目录不存在一并创建
 * <p>
 * Author: secondriver
 * Created: 2019/3/31
 */
public class TestFile {
    
    public static void code1() {
        File file = new File("D:\\test\\Java7.java");
        boolean rs = false;
        try {
            rs = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (rs) {
            System.out.println("创建文件成功");
        } else {
            System.out.println("创建文件失败");
        }
    }
    
    public static void code2() {
        File file = new File("D:" + File.separator + "test" + File.separator + "Java7.java");
        
        if (file.exists()) {
            boolean rs = file.delete();
            System.out.println("delete 的结果：" + rs);
        } else {
            try {
                boolean rs = file.createNewFile();
                System.out.println("createNewFile 的结果：" + rs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void code3() {
        File file = new File("D:" + File.separator + "test" + File.separator + "Java7.java");
        System.out.println("父目录：" + file.getParent());
        File parentFile = file.getParentFile();
        System.out.println("父目录（File）:" + parentFile.isDirectory());//true
        
        //D:\test\java7\javase => 目录不存在，父目录也不存在
        String pathname = "D:" + File.separator + "test" + File.separator + "java7" + File.separator + "javase";
        File directory = new File(pathname);
        System.out.println(directory.mkdirs());
        
        
    }
    
    public static void code4() {
        File file = new File("D:" + File.separator + "test" + File.separator + "Java7.java");
        
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件对象是否表示文件：" + file.isFile());
        System.out.println("文件对象是否表示目录：" + file.isDirectory());
        Date date = new Date(file.lastModified());
        System.out.println("最近修改时间：" + date);
        System.out.println("文件大小(字节)：" + file.length());
    }
    
    
    public static void code5() {
        //D:\test
        File file = new File("D:" + File.separator + "test");
        if (file.isDirectory()) {
            System.out.println("File对象表示的是一个目录");
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println(
                            (f.isDirectory() ? "d" : "f") + "  " + f.getName());
                }
            }
            
        }
    }
    
    public static void main(String[] args) {
        File file = new File("C:\\Windows");
        //考虑使用多线程，异步去遍历
        new Thread(new Runnable() {
            @Override
            public void run() {
                
                int level = 0;
                System.out.println(file.getName());
                listFiles(file, level + 1);
            }
        }).start();
        System.out.println("main方法执行代码");
        
    }
    
    public static String computePrefix(int level) {
        StringBuilder sb = new StringBuilder("|-");
        for (int i = 0; i < level; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
    
    public static void listFiles(File file, int level) {
        if (file.isDirectory()) {
            //file对象下的所有目录及文件列出来
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println(computePrefix(level) + f.getName());

                    if (f.isDirectory()) {
                        listFiles(f, level + 1);
                    }
                }
            }
        } else {
            System.out.println(computePrefix(level) + file.getName());
        }
    }
}
