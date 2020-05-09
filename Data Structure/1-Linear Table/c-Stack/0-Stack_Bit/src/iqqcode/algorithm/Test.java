package iqqcode.algorithm;

import iqqcode.algorithm.impl.ArrayStack;

//测试顺序栈


public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.peek()); //返回栈顶元素(不出栈)
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
    }
}




//测试链式栈

/*
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek()); //返回栈顶元素(不出栈)
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
    }
}
*/
