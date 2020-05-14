package DataStruct.Queue.impl;

import DataStruct.Queue.Queue;

public class LinkedQueue<E> implements Queue<E> {
    private Node head;   //当前队列头结点
    private Node tail;   //当前队列的尾节点，用于元素的入队操作
    private int size;    //队列中的元素个数

    //存放数据的内部节点
    private class Node {
        private E data;
        private Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void inQueue(E e) {
        Node newNode = new Node(e,null);
        if(head == null) {
            head = tail = newNode;
        }else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E outQueue() {
        if(isEmpty()) {
            System.err.println("当前对列为空...");
            return null;
        }
        E result = head.data;
        head.data = null;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            System.err.println("当前对列为空...");
            return null;
        }
        return head.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
