package com.iqqcode.json.test;

import	java.util.HashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iqqcode.json.domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-16 16:32
 * @Description:
 */
public class JsonContainer {
    @Test
    public void testList() throws JsonProcessingException {
        Person per = new Person();
        per.setName("Mr.Q");;
        per.setAge(22);
        per.setAddress("Inner Mongolia");
        per.setBirthday(new Date());

        Person per1 = new Person();
        per1.setName("Mr.Q");;
        per1.setAge(22);
        per1.setAddress("Inner Mongolia");
        per1.setBirthday(new Date());

        Person per2 = new Person();
        per2.setName("Mr.Q");;
        per2.setAge(22);
        per2.setAddress("Inner Mongolia");
        per2.setBirthday(new Date());

        List<Person> list = new ArrayList<Person>();
        list.add(per);
        list.add(per1);
        list.add(per2);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        /**
         * [
         *  {"name":"Mr.Q","age":22,"address":"Inner Mongolia","birthday":"2020-03-16"},
         *  {"name":"Mr.Q","age":22,"address":"Inner Mongolia","birthday":"2020-03-16"},
         *  {"name":"Mr.Q","age":22,"address":"Inner Mongolia","birthday":"2020-03-16"}
         * ]
         */
        System.out.println(json);
    }

    @Test
    public void testMap() throws JsonProcessingException {
        Map<String,Object> map = new HashMap<String, Object> ();
        map.put("name", "Mr.Q");
        map.put("age", 22);
        map.put("address" , "Xian");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        //{"address":"Xian","name":"Mr.Q","age":22}
        System.out.println(json);
    }
}
