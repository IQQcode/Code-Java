package javaSE.dataStruct.stack.impl;

import javaSE.dataStruct.stack.Stack;

public class LinkedStack<T> implements Stack<T> {
    //当前栈顶元素
    private Node top;
    //当前栈的大小
    private int currentSize;

    //定义节点结构
    private class Node {
        private T t; //存放的具体数据
        private Node next; //存放的下一个节点地址

        public Node(T t, Node next) {
            this.t = t;  //存放栈中具体的数据
            this.next = next;  //存放的下一个节点地址
        }
    }
    @Override
    public boolean push(T t) {
        Node newNode = new Node(t,null); //创建新节点
        if(top == null) {
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
        currentSize++;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            System.out.println("当前栈为空");
        }
        //维护栈，取出栈顶元素
        T result = top.t;
        top = top.next;
        currentSize--;
        return result;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            System.out.println("当前栈为空");
        }
        return top.t;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize ==0;
    }
}
