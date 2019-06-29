package com.ischoolbar.programmer.util;

/**
 * String 类一些公用操作方法
 */

public class StringUtil {
    public static boolean isEmpty(String str) {
        if(str == null || "".equals(str)) {
            return true;
        }
        return false;
    }
}
