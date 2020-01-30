package com.sad;

import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-06 22:52
 * @Description:校赛蓝桥杯第一题,用时40分没写出来
 *  求n!并显示最后一位非0数
 *  7! = 5040 ---> 4
 */
public class IDonotKnow {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int sum = FactorialSum.FactorialSum_fac(num);
        System.out.println(sum);
        while(sum % 10 == 0) {
             sum /= 10 ;
        }
        int dec = sum % 10;
        System.out.println(dec);
    }

    public static int FactorialSum_fac(int num) {
        if(num == 0 || num == 1) {
            return 1;
        }else {
            return num * FactorialSum_fac(num -1);
        }
    }
}
