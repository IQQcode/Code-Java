package org.iqqcode.utils;
import	java.util.Properties;

import org.junit.Assert;
import org.junit.Test;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 08:05
 * @Description:
 */
public class CommUtilsTest {

    @Test
    public void loadProperties() {
       String fileNames = "db.properties";
       Properties properties = CommUtils.loadProperties(fileNames);
       //System.out.println(properties);
        // 如果加载成功,则 url不为空
       String url = properties.getProperty("url");
       Assert.assertNotNull(url); //表示传入的对象不是空对象

    }
}