package com.FileClass;

import java.io.File;
import java.io.IOException;

/**
 * 1.编写文件的基本操作
 *
 * 根据文件路径，创建文件夹
 */


public class CreateFile {
    public static void main(String[] args) {
        //1.取得File对象
        File file = new File(File.separator + "G:" + File.separator +
                "javaTest" + File.separator + "www" + File.separator + "javaSE.IO" + File.separator + "Hellow!");

        //2.判断父路径是否存在，不存在则创建多级父路径
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();    //多级父路径 + mkdirs();
        }

        //3.判断文件是否存在，不存在则创建文件
        if(file.exists()) {
            System.out.println("文件已存在！");
        }else {
            try {
                file.createNewFile();
                System.out.println("javaTest文件夹创建成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




