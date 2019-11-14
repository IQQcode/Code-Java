package com.jdcb.basic;

import com.jdcb.util.CommUtils;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;


/**
 * @Author: Mr.Q
 * @Date: 2019-10-12 23:11
 * @Description:
 */
public class JDBCPropertiesTest {

    @Test
    public void main() {
        Properties properties = CommUtils.LoadProperties("db.properties");
        System.out.println(properties);
    }
}