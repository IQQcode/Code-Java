package org.iqqcode.JsonUtils;

import org.iqqcode.Model.User;
import org.junit.Test;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 11:31
 * @Description:
 */
public class JsonCommUtilsTest {

    @Test
    public void gsonTest1() {
        User user = new User();
        user.setId(10);
        user.setUserName("test");
        user.setPassword("123");
        String jsonStr = JsonCommUtils.object2Json(user);
        System.out.println(jsonStr);
    }

    @Test
    public void gsonTest2() {
        String jsonStr = "{\"id\":10,\"userName\":\"test\",\"password\":\"123\"}";
        User user = (User) JsonCommUtils.json2Object(jsonStr,User.class);
        System.out.println(user);
    }
}

