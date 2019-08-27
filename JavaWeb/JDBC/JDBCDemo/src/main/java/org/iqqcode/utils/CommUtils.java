package org.iqqcode.utils;


import java.io.IOException;
import	java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 07:56
 * @Description:封装基础的工具方法(如加载配置文件,Json序列化)
 */
public class CommUtils {

    private CommUtils() { }

    /**
     * 根据指定文件名加载配置文件
     * @param fileNames
     * @return
     */
    public static Properties loadProperties(String fileNames) {
        Properties properties = new Properties();
        // 获取到当前配置文件夹下的文件输入流
        // 获取输入流步骤: 获取反射对象--->获取类加载器--->获取类加载器下所有的同目录文件
        InputStream inputStream = CommUtils.class.getClassLoader().getResourceAsStream(fileNames);
        // 加载配置文件中的所有内容
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
