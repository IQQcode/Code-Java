package Test.Day23;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * 题目描述：
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
 * A1=能被5整除的数字中所有偶数的和；
 * A2=将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
 * A3=被5除后余2的数字的个数；
 * A4=被5除后余3的数字的平均数，精确到小数点后1位；
 * A5=被5除后余4的数字中最大数字。
 *
 * 13 1 2 3 4 5 6 7 8 9 10 20 16 18
 *
 * 30 11 2 9.7 9
 */
public class Test02 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       String[] str = input.nextLine().split(" ");
       int[] arr = new int[str.length - 1];

       //int N=in.nextInt();
        //int num[]=new int[N];//n个整数

       for(int i=0,j=1;i<str.length-1;i++,j++) {
           arr[i] = Integer.parseInt(str[j]);
       }
       int A1=0,A2=0,A3=0,A5=0;
       double A4=0;
       int temp = 1,count = 0;
        for(int i = 0;i < arr.length; i++) {
           if(arr[i]%2 == 0 && arr[i]%5 == 0) {
               A1 += arr[i];
           }else if(arr[i] % 5 == 1) {
               A2 += (temp * arr[i]);
               temp = -temp;
           }else if(arr[i] % 5 == 2) {
               A3++;
           }else if(arr[i] % 5 == 3) {
               count++;
               A4 += arr[i];
           }else if(arr[i] % 5 == 4) {
               if(A5 < arr[i]) {
                   A5 = arr[i];
               }
           }
       }

        if(A1 == 0) {
            System.out.print("N" + " ");
        }else {
            System.out.print(A1 + " ");
        }
        if(A2 == 0) {
            System.out.print("N" + " ");
        }else {
            System.out.print(A2 + " ");
        }
        if(A3 == 0) {
            System.out.print("N" + " ");
        }else {
            System.out.print(A3 + " ");
        }
        if(count == 0) {
            System.out.print("N" + " ");
        }else {
            // A4保留1位小数输出
            A4 = A4 / count;
            DecimalFormat num = new DecimalFormat("0.0");
            System.out.print(String.format(num.format(A4)) + " ");
        }
        if(A5 == 0) {
            System.out.print("N");
        }else {
            System.out.print(A5);
        }

    }
}
