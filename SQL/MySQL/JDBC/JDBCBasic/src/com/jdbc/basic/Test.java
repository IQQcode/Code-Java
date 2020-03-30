package com.jdbc.basic;


import com.jdbc.utils.CommUtils;

import java.util.Properties;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-11 20:35
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Properties properties = CommUtils.LoadProperties("db.properties");
        String url = properties.getProperty("URL");
        System.out.println(url);
    }
}
