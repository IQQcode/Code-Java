package com.iqqcode;


/**
 * @Author: Mr.Q
 * @Date: 2020-03-30 22:02
 * @Description: 通过交换字符(toCharArray)反转
 */
public class Method4 {
    public static void main(String[] args) {
        Method4 method4 = new Method4();
        String s = "ABCDE";
        System.out.println(" input :: " + s);
        System.out.println(" output :: " + method4.reverseWithSwaps(s));
    }

    public String reverseWithSwaps(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length - 1;
        //Math.floor对浮点数向下取整
        int half = (int) Math.floor(arr.length / 2);
        char c;
        for (int i = len; i >= half; i--) {
            c = arr[len - i];
            arr[len - i] = arr[i];
            arr[i] = c;
        }
        return String.valueOf(arr);
    }
}
