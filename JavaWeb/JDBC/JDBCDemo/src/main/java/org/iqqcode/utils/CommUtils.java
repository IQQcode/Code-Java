package org.iqqcode.utils;
import java.io.IOException;
import	java.io.InputStream;


import java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 07:56
 * @Description:封装基础的工具方法(如加载配置文件，Json序列化)
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
