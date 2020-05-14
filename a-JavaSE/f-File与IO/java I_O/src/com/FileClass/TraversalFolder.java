package com.FileClass;


import java.io.File;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-15 20:23
 * @Description:
 */
public class TraversalFolder {
    public static void main(String[] args) {
        File file = new File(File.separator + "F:" + File.separator + "Code-Java");

        //将 I/O 操作放在子线程中进行
        new Thread(()->{
            long start = System.currentTimeMillis();
            listAllFiles(file);
            long end = System.currentTimeMillis();
            System.out.println("文件遍历结束，共耗时： "
                    + (end - start) + "毫秒");
        }).start();
        System.out.println("main线程结束");
    }

    public static void listAllFiles(File file) {
        if(file.isFile()) {
            System.out.println(file);
        }else {
            if(file.exists() && file.isDirectory()) {
                //列出该目录的文件夹组成
                File[] files = file.listFiles();
                for(File file1 : files) {
                    //递归调用，进入子目录直至全部列举完该文件夹
                    listAllFiles(file1);
                }
            }
        }
    }
}
