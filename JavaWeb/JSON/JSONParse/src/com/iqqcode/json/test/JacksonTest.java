package com.iqqcode.json.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iqqcode.json.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Date;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-16 15:29
 * @Description:
 */
public class JacksonTest {
    /**
     * @Java对象转为JSON
     * 转换方法：
     * @writeValue(参数，obj);
     * 参数：
     *      1. File：将obj对象转换为JSON字符串，并保存到指定的文件中
     *      2. Writer：将obj对象转换为JSON宇符串，并将JSON数据填充到字符输岀流中
     *      3. OutputStream：将obj对象转换为JSON字符串，并将JSON数据填充到字节输岀流中
     * @writeValueAsString(obj)：将对象转为json字符串
     */
    @Test
    public void test1() throws Exception {
        Person per = new Person();
        per.setName("Mr.Q");;
        per.setAge(22);
        per.setAddress("Inner Mongolia");
        //创建Jackson对象ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(per);
        //{"name":"Mr.Q","age":22,"address":"Inner Mongolia"}
        //System.out.println(json);

        //writeValue:将数据写到文件中
        mapper.writeValue(new File("F://Json.txt"),per);

        //writeValue:将数据写到输出流中
        mapper.writeValue(new FileWriter("F://JsonStream.txt"),per);
        mapper.writeValue(new FileOutputStream("F://JsonTest.txt"),per);
    }

    /**
     * @JsonIgnore 排除属性
     * @JsonFormat 属性值格式化
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Person per = new Person();
        per.setName("Mr.Q");;
        per.setAge(22);
        per.setAddress("Inner Mongolia");
        per.setBirthday(new Date());
        //创建Jackson对象ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(per);
        //{"name":"Mr.Q","age":22,"address":"Inner Mongolia","birthday":1584346372533}
        System.out.println(json);
    }
}
