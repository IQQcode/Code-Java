package com.iqqcode.lambda;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-27 14:58
 * @Description:lambda表达式推倒
 */
interface Lambdas {
    void lambda();
}

public class LambdaLearn {
    public static void main(String[] args) {
        Lambdas lb = () -> {
            System.out.println("学习lambda表达式...");
        };
        lb.lambda();
    }
}
