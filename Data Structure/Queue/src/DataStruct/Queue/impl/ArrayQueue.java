package DataStruct.Queue.impl;

import DataStruct.Queue.Queue;

public class ArrayQueue<E> implements Queue<E> {
    //存放数据的数组
    private Object[] elementData;
    private int head;
    private int tail;

    //Object 数组初始化
    public ArrayQueue(int maxSize) {
        elementData = new Object[maxSize];
    }

    /**
     * 入队  --->  改进
     * @param e 要插⼊入的元素
     */

    /*@Override
    public void inQueue(E e) {
        if(tail == elementData.length) {
            System.err.println("对列已满...");
            return ;
        }
        elementData[tail++] = e;
    }*/

    //****数据搬移入队***
    @Override
    public void inQueue(E e) {
        if(tail == elementData.length) {
           if(head == 0) {
               System.err.println("对列已满！！！");
           }else {
               //数据搬移
               for(int i = head; i < tail; i++) {   //数据开始的地方搬移
                   elementData[i-head] = elementData[i];
               }
               //重新赋值头尾指针
               tail = tail - head;
               head = 0;
           }
        }
        elementData[tail++] = e;
    }

    @Override
    public E outQueue() {
        if(isEmpty()) {
            System.err.println("当前队列为空！");
            return null;
        }
        return (E) elementData[head++];
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            System.err.println("当前队列为空！");
            return null;
        }
        return (E) elementData[head];
    }

    @Override
    public int getSize() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
