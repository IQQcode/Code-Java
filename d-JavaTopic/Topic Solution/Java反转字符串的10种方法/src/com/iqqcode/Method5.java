package com.iqqcode;


/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 22:26
 * @Description: 使用 XOR(^) 操作符反转
 */
public class Method5 {
    public static void main(String[] args) {
        Method5 method5 = new Method5();
        String s = "ABCDE";
        System.out.println(" input :: " + s);
        System.out.println(" output :: " + method5.reverseWithXOR(s));
    }

    private String reverseWithXOR(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        int half = (int) Math.floor(array.length / 2);
        for (int i = 0; i < half; i++) {
            //两数交换
            array[i] ^= array[len - i - 1];
            array[len - i - 1] ^= array[i];
            array[i] ^= array[len - i - 1];
        }
        return String.valueOf(array);
    }
}
