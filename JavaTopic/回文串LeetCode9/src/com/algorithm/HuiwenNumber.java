package com.algorithm;

import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-11 21:44
 * @Description:
 */
public class HuiwenNumber {
    public static int isPalindrome(int x) {
        int rs = 0;  int temp = x;
        while(temp > 0) {
            rs *= 10;
            rs += temp % 10;
            temp /= 10;
        }
        if(x == rs) {
            return x;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int msg = 0;
        System.out.print("请输入判断回文数的区间： ");
        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int end = input.nextInt();
        for(int i = start; i <= end; i++) {
             // 偶数回文数
            // if(isPalindrome(i) > 0)
            if(isPalindrome(i) > 0) {
                System.out.println(isPalindrome(i));
                msg++;
            }
        }
        System.out.println("该区间回文数共有" + msg + "个！");
    }
}
