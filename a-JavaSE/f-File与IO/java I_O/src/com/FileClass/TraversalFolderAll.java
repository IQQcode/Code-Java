package com.FileClass;


import java.io.File;

/**
 * @Author: Mr.Q
 * @Date: 2019-07-22 12:18
 * @Description:遍历文件夹
 */


/**
 *@public File[] listFiles()
 *
 * 列出文件目录下的所有内容(第一级信息)
 *
 * 递归打印当前目录下所有层级的文件信息
 */


/**
 * 多线程实现
 *
 * 递归打印当前目录下所有层级的文件信息
 */

public class TraversalFolderAll {
    public static void main(String[] args) {
        File file = new File("F:" + File.separator +
                "Code-Java");
        //多线程，异步遍历
        new Thread(()-> {

                int level = 0;
                long start = System.currentTimeMillis();
                System.out.println(file.getName());
                listFiles(file,level + 1);
                long end = System.currentTimeMillis();
                System.out.println("桌面文件遍历结束，共耗时： "
                        + (end - start) + "毫秒");

        }).start();
        System.out.println("main方法执行代码");
    }

    public static String computerPrefix(int level) {
        StringBuilder msg = new StringBuilder("|");
        for(int i =0; i < level; i++) {
            msg.append("-");
        }
        return msg.toString();
    }

    public static void listFiles(File file,int level) {
        if(file.isDirectory()) {
            //file对象下的所有目录及文件夹列出来
            File[] files = file.listFiles();
            if(file != null) {
                for(File f : files) {
                    System.out.println(computerPrefix(level) +
                            file.getName());
                    if(f.isDirectory()) {
                        listFiles(f, level + 1);
                    }else {
                        System.out.println(computerPrefix(level) + file.getName());
                    }
                }
            }
        }
    }
}

