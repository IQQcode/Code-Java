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
        File file = new File(File.separator + "C:" + File.separator +
                "Users" + File.separator + "j2726" + File.separator + "Desktop" + File.separator +"javaIO" + File.separator + "Mr.Q" + File.separator +"File" + File.separator + "Hello!");

        //2.判断父路径是否存在，不存在则创建多级父路径
        if(!file.getParentFile().exists()) {
            //多级父路径 + mkdirs()创建文件
            file.getParentFile().mkdirs(); // 如果直接 file.mkdirs()则会创建为文件夹
        }

        //3.判断文件是否存在，不存在则创建文件
        if(file.exists()) {
            System.err.println("文件已存在！删除后重新创建...");
            file.delete();
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

