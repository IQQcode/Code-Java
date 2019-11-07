package com.BlueBridge;

import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-11-07 23:28
 * @Description:汉诺塔问题
 */
public class Hanoi {
    public static void hanoi(int n, String A, String B, String C) {
        if(n == 1) {
            System.out.println("盘 " + n + " 由 " + A + " 移至 " + C);
        }else {
            hanoi(n-1, A, C, B);
            System.out.println("盘 " + n +" 由 " + A + " 移至 " + C);
            hanoi(n-1, B, A, C);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        hanoi(n,"A","B","C");
    }
}
