package com.jdcb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-11 19:13
 * @Description:封装公共的工具方法
 */
public class CommUtils {
    /**
     * 加载配置文件
     * @param fileNames 要加载的配置文件名称
     * @return
     */
    public static Properties LoadProperties(String fileNames) {
        Properties properties = new Properties();
        //将配置文件转为输入流
        InputStream in = CommUtils.class.getClassLoader().getResourceAsStream(fileNames);
        //加载配置信息
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
