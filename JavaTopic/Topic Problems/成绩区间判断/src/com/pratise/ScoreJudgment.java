package com.pratise;

import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-27 22:56
 * @Description:成绩区间判断
 *      A级   [85,100]
 *      B级   [70,85)
 *      C级   [60,70)
 *      D级   [0,60)
 */
public class ScoreJudgment {
    public static String judgMent(double score) {
        String grade = null;
        if(score > 100 || score < 0) {
            return "Input is illegal...";
        }else if (score >= 85) {
            return "A";
        }else if(score >= 70) {
            return "B";
        }else if(score >= 60) {
            return "C";
        }else {
            return "D";
        }
    }

    public static void main(String[] args) {
        double score = 0;
        System.out.print("请输入你的成绩： ");
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt()) {
            score = input.nextDouble();
            System.out.print("你的成绩为：");
            System.out.println(judgMent(score));
        }
    }
}
