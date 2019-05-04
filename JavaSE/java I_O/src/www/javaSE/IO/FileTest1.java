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
 *@public File[] listFiles()
 *
 * 列出文件目录下的所有内容(第一级信息)
 *
 * 递归打印当前目录下所有层级的文件信息
 */


public class FileTest1 {
    public static void main(String[] args) {
        File file = new File(File.separator + "F:" + File.separator + "IDEA");

        //将 I/O 操作放在子线程中进行
        new Thread(()->{
            long start = System.currentTimeMillis();
            listAllFiles(file);
            long end = System.currentTimeMillis();
            System.out.println("桌面文件遍历结束，共耗时： " + (end - start) + "毫秒");
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


/*
public class FileTest1 {
    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "IDEA");
        //多线程，异步遍历
        new Thread(new Runnable() {
            @Override
            public void run() {
                int level = 0;
                System.out.println(file.getName());
                listFiles(file,level + 1);
            }
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
                    System.out.println(computerPrefix(level) + file.getName());
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
*/
