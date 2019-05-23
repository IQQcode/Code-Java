package DataStruct.Queue.impl;

import DataStruct.Queue.Queue;

/**
 * 环形队列  -->  优化顺序队列的数据搬移工作
 *
 * 数据搬移的本质： 修改tail指针下标
 *
 * @环形队列为空：  head == tail;
 * @环形队列为满：  (tail + 1) % elementData.length == head;
 *
 *
 * @param <E>
 */


public class ArrayLoopQueue<E> implements Queue<E> {
    private Object[] elementData;
    private int head;
    private int tail;
    private int size;

    public ArrayLoopQueue(int maxSize) {
        //多开辟一块空间来判断环形队列为空，为满
        elementData = new Object[maxSize+1];
    }

    @Override
    public void inQueue(E e) {
        if( (tail + 1) % elementData.length == head) {
            System.err.println("队列已满！！！");
            return;
        }
        elementData[tail] = e;
        tail = (tail + 1) % elementData.length;
        size++;
    }

    @Override
    public E outQueue() {
        if(isEmpty()) {
            System.err.println("当前队列为空！");
            return null;
        }
        E result = (E) elementData[head];
        head = (head+1) % elementData.length;
        size--;
        return result;
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
        return size;
        // return (tail+head) % elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
