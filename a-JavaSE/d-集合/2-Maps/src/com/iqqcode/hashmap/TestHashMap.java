package com.iqqcode.hashmap;


/**
 * @Author: Mr.Q
 * @Date: 2020-05-31 11:55
 * @Description:测试hash算法
 */
public class TestHashMap {
    /**
     *
     * @param hashcode 任意整数
     * @param len 长度为2的整数幂
     * @return
     */
    public static int myHash(int hashcode, int len) {
        System.out.println(hashcode & (len - 1));
        //leh为2的整数幂情况下，和取余的值一样
        System.out.println(hashcode % len);
        return hashcode & (len - 1);
    }

    public static void main(String[] args) {
        int hashcode = 799999;
        int len = 16;
        myHash(hashcode, len);
    }
}
