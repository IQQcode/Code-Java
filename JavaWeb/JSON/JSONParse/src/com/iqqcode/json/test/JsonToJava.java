package com.iqqcode.json.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.iqqcode.json.domain.Person;
import org.junit.Test;
import java.io.IOException;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-16 16:50
 * @Description:
 */
public class JsonToJava {
    @Test
    public void test() throws IOException {
        //初始化JSON字符串
        String json = "{\"name\":\"Mr.Q\",\"age\":22,\"address\":\"Inner Mongolia\",\"birthday\":\"2020-03-16\"}";
        ObjectMapper mapper = new ObjectMapper();
        //转换为Java对象
        Person per = mapper.readValue(json, Person.class);
        System.out.println(per);
    }
}
