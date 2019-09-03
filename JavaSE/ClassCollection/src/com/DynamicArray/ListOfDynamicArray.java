package com.DynamicArray;


/**
 * @Author: Mr.Q
 * @Date: 2019-08-22 20:28
 * @Description:链表---实现动态数组扩容
 */
class MyArrayOfList<E> {
    private class Node {
        E data; //数据
        Node next; //前指针
        Node prev; //后指针

        Node(E data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    private int size;
    private Node head; //链表头指针
    private Node tail; //链表尾指针


    public void add(E data) {
        // 双向链表--->尾插
        Node node = new Node(data,null,tail);
        if(tail == null) {
            //此时链表为空
            head = tail = node;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public String toString() {
        return "MyArrayOfList{" +
                "size=" + size +
                '}';
    }
}
public class ListOfDynamicArray {
    public static void main(String[] args) {
        MyArrayOfList<String> msg = new MyArrayOfList<>();
        msg.add("SchoolStarts..");
        msg.add("大三了！！");
        msg.add("A");
        msg.add("B");
        msg.add("C");
        msg.add("D");
        System.out.println(msg);
    }
}
