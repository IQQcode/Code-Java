package com.iqqcode.lambda;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-27 15:43
 * @Description:lambda表达式参数简化
 */
interface Lambda {
    void lambda(String str);

    //int add(int i, int j);
}

public class Simplify {
    public static void main(String[] args) {
        //简化参数类型、简化括号、简化代码块{ }
        Lambda lb = str -> System.out.println(str);
        lb.lambda("lambda表达式");

        /*Lambda lb = (i, j) -> {
            return i + j;
        };
        System.out.println(lb.add(1 , 2));*/
    }
}