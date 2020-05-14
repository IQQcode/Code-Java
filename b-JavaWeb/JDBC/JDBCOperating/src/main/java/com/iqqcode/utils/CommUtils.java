package com.iqqcode.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-22 21:19
 * @Description:加载配置文件
 */
public class CommUtils {
    public static Properties loadProperties(String fileNames) {
        Properties properties = new Properties();
        InputStream in = CommUtils.class.getClassLoader().getResourceAsStream(fileNames);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
