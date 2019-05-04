package com.bittech.file;

import java.io.File;

/**
 * 文件拷贝工具类
 *
 */

public class FileCopyUtil {

    private FileCopyUtil() { }

    /**
     *判断要拷贝的源路径是否存在
     * @param path 源路径的信息
     * @return
     */
    public static boolean fileIsExists(String path) {
        return new File(path).exists();
    }
    
    /**
     * 拷贝方法
     *
     * @param sourceFilePath 源文件
     * @param destFilepath   目的文件
     */
    public static void cp(String sourceFilePath, String destFilepath) {
    
    }
    
    private static void dataCopy(File source, File dest) {
    
    }
    
    /**
     * 空 => null ""
     * 检查参数不能空，如果为空抛出异常
     *
     * @param args 参数
     * @param msg  异常提示信息
     */
    private static void checkArgumentNotEmpty(Object args, String msg) {
    
    }
    
    private static void checkFile(File file, String msg) {
    
    }
    
    private static void checkAndMkParentFile(File file, String msg) {
    
    }
    
    
    public static void main(String[] args) {

        
    }
}
