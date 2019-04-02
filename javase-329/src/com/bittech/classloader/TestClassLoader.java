package com.bittech.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author: secondriver
 * Created: 2019/3/29
 */
public class TestClassLoader {
    
    public static void code1() {
        /*
        Class classz = Member.class;
        
        System.out.println(classz.getClassLoader());
        //ClassLoader getParent 返回的类型 ClassLoader
        System.out.println(classz.getClassLoader().getParent());
        System.out.println(classz.getClassLoader().getParent().getParent());
//        System.out.println(classz.getClassLoader().getParent().getParent().getParent());
    */
        //java.lang.Object
        // Object obj = new Object();
        
        try {
            //AppClassLoader
            //Member Application ClassPath
            ClassLoader classLoader = Class.forName("com.bittech.classloader.Member")
                    .getClassLoader();
            System.out.println(classLoader);
            Class classz = classLoader.loadClass("com.bittech.classloader.Member");
            Member member = (Member) classz.newInstance();
            System.out.println(member);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String className = "com.bittech.classloader.Member";
        Class classz = new MyClassLoader().loadData(className);
        
        try {
            Class classz2 = Class.forName(className);
            
            //同一个类，由不同的类加载器所加载
            //Class对象就不相等了
            System.out.println(classz.getClassLoader());
            System.out.println(classz2.getClassLoader());
            System.out.println(classz == classz2);//
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Member {
    
    @Override
    public String toString() {
        return "Member";
    }
}


// className -> class file -> byte[] -> defineClass Class
class MyClassLoader extends ClassLoader {
    
    public Class loadData(String className) {
        byte[] data = classBytes(className);
        return super.defineClass(className, data, 0, data.length);
    }
    
    
    //File
    //net
    //database
    //消费服务
    //...
    private byte[] classBytes(String className) {
        //com.bittech.classloader.Member
        //com/bittech/classloader/Member.class
        //路径：classpath
        //E:\worskpace\java7_code\javase-329\out\production\javase-329\com\bittech\classloader\Member.class
        String classPath = "E:\\worskpace\\java7_code\\javase-329\\out\\production\\javase-329";
        
        String classFile = classPath + "\\" + className.replace(".", "\\") + ".class";
        
        //File I/O
        //文件内容转换为byte[]
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (FileInputStream in = new FileInputStream(classFile)) {
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } catch (IOException e) {
        }
        return out.toByteArray();
        
    }
}
