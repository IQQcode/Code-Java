package com.sad;


import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-06 23:57
 * @Description:前n项阶乘和 1！+2！+3！
 */
public class theNo_FactorialSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int temp = 1;  int sum = 0;
        for(int i = 1; i <= num;i++) {
            temp *= i;
            sum += temp;
        }
        System.out.println(sum);
    }
}
