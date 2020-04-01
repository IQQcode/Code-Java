package com.iqqcode;


/**
 * @Author: Mr.Q
 * @Date: 2020-03-31 15:47
 * @Description:双指针
 */
public class Method11 {
    public static void main(String[] args) {
        Method11 method = new Method11();
        String str = "ABCDE";
        System.out.println(" input :: " + str);
        System.out.println(" output :: " + method.fun(str));
    }

    private String fun(String s) {
        char[] chs = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chs);
    }
}
