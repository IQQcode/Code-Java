package org.iqqcode.test;


import org.apache.commons.beanutils.BeanUtils;
import org.iqqcode.domain.User;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-10 16:04
 * @Description:
 */
public class BeanUtilsTest {
    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        BeanUtils.setProperty(user,"username","admin");
        System.out.println(user);
    }
}
