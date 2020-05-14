package com.ExceptionDemo;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-04 17:01
 * @Description: finally代码块执行了 x = 1,但是并未return 回去作修改
 */
public class ExceptionTest03 {
    public static int test() {
        int x = 0;
        try {
            return x;
        }catch (Exception e) {
            x = 2;
            return x;
        }finally {
           x = 1;
        }
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}
