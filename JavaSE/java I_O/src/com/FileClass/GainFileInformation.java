package com.FileClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-22 12:24
 * @Description:取得文件信息
 */

public class GainFileInformation {
    public static void main(String[] args) {

        //1.取得File对象 C:\Users\HASEE\Desktop

        File file = new File(File.separator + "C:" + File.separator +
                "Users" + File.separator + "j2726" + File.separator + "Desktop"
                + File.separator + "0.jpg");

        //保证文件存在，且一定是文件
        if(file.exists() && file.isFile()) {
            System.out.println(file.length()/1024 + "kb");
            System.out.print("创建时间为: ");
            Date date = new Date(file.lastModified());
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(date));
        }
    }
}



