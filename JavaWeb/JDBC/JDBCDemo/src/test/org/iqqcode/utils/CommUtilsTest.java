package org.iqqcode.utils;
import	java.util.Properties;

import org.iqqcode.utils.CommUtils;
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
       String url = properties.getProperty("url");
       Assert.assertNotNull(url);

    }
}