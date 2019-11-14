package com.algorithm;

import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-11 21:58
 * @Description:回文字符串判断
 */
public class HuiwenString {

    public static boolean isPalindromeString(String str) {
        int left = 0;
        int right = str.length() - 1;
        if(str.length() == 0 || str == null) {
            return false;
        }
        while(left <= right) {
            if( str.charAt(left) == str.charAt(right) ) {
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.print("请输入字符串： ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(isPalindromeString(str));
    }
}
