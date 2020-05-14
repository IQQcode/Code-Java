package com.ExceptionDemo;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-04 16:59
 * @Description: finally代码块不执行
 */
public class ExceptionTest02 {
    public static int test() {
        try {
            throw new Exception("HeHe!");
        }catch (Exception e) {
            return 2;
        }finally {
            System.exit(0);
            return 3;
        }
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}

