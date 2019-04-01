package www.javaSE.IO;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import  java.util.Date;

/**
 * 1.编写文件的基本操作(存在则创建，不存在则删除)
 *
 * 创建文件夹
 */

/*
public class FileTest1 {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
*/

/**
 * 取得文件信息
 */

/*
public class FileTest1 {
    public static void main(String[] args) {

        //1.取得File对象  C:\Users\HASEE\Desktop

        File file = new File(File.separator + "C:" + File.separator +
                "Users" + File.separator + "HASEE" + File.separator + "Desktop"
                + File.separator + "0.jpg");

        if(file.exists() && file.isFile()) {
            System.out.println(file.length()/1024 + "kb");
            Date date = new Date(file.lastModified());
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(date));
        }
    }
}
*/




/**
 *
 * 列出文件目录下的所有内容(第一级信息)
 *
 * 递归打印当前目录下所有层级的文件信息
 */


public class FileTest1 {
    public static void main(String[] args) {
        File file = new File(File.separator + "F:" + File.separator + "IDEA");
        //保证目录存在
        if(file.exists() && file.isDirectory()) {
            //列出目录中的全部内容
            File[] result = file.listFiles();
            for(File file1 : result) {
                System.out.println(file1);
            }
        }
    }


}
