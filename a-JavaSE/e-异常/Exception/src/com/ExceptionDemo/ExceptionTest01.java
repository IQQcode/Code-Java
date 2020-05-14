package com.ExceptionDemo;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-04 16:55
 * @Description: finally代码块先执行
 */

public class ExceptionTest01 {
    public static int test() {
        try {
            throw new Exception("HeHe!");
        }catch (Exception e) {
            return 2;
        }finally {
            return 3;
        }
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}
