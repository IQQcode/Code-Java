package org.iqqcode.JsonUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-01 11:31
 * @Description:封装基础的工具方法,如加载配置文件、json序列化等
 */

public class JsonCommUtils {
    private static final Gson gson = new GsonBuilder().create();

    private JsonCommUtils(){ }

    public static String object2Json(Object obj) {
        return gson.toJson(obj);
    }

    public static Object json2Object(String jsonStr,Class objClass) {
        return gson.fromJson(jsonStr,objClass);
    }
}

