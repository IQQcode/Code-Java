package iqqcode.algorithm.test;

import iqqcode.algorithm.stack.ArrayStack;
import iqqcode.algorithm.stack.LinkStack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-09 14:40
 * @Description:测试
 */
public class TestStack {
    //链表栈测试
    @Test
    public void testLinkStack() {
        LinkStack<String> stack = new LinkStack<>();
        //压栈测试
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        stack.push("Go");
        stack.push("JavaScript");
        for (String str : stack) {
            System.out.println(str);
        }
        System.out.println("弹出元素为： " + stack.pop());
        System.out.println("栈中剩余元素个数为： " + stack.size());
        System.out.println("栈顶元素为： " + stack.peek());
    }

    //测试数组栈
    @Test
    public void testArrayStack() {
        ArrayStack<String> stack = new ArrayStack<>(3);
        //压栈测试
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        stack.push("Go");
        stack.push("JavaScript");
        for (Object o : stack) {
            System.out.println(o);
        }
        System.out.println("弹出元素为： " + stack.pop());
        System.out.println("栈中剩余元素个数为： " + stack.size());
        System.out.println("栈顶元素为： " + stack.peek());
    }
}
