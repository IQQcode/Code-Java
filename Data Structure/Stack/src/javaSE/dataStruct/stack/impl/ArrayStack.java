package javaSE.dataStruct.stack.impl;

import javaSE.dataStruct.stack.Stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack {
    //存放数据
    private Object[] elementData;
    //最对元素个数
    private int maxsize;
    //当前栈中元素个数
    private  int currrentSize;

    public ArrayStack(int maxsize) {
        this.maxsize = maxsize;
        elementData = new Object[maxsize];
    }


    /*
    @Override
    public boolean push(Object o) {
        if(currrentSize == maxsize) {
            System.err.println("栈已满，无法添加新的元素！！！");
            return false;
        }
        elementData[currrentSize++] = o;
        return true;
    }
    */


    /**
     * 扩容栈
     * @param o
     * @return
     */

    @Override
    public boolean push(Object o) {
        if(currrentSize == maxsize) {
            //扩容
            int oldSize = maxsize;
            int newSize = oldSize << 1;
            if(newSize + 1 > Integer.MAX_VALUE) {
                System.out.println("栈已达到最大扩容...");
                return false;
            }
            maxsize = newSize;
            elementData = Arrays.copyOf(elementData,maxsize);
        }
        elementData[currrentSize++] = o;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            System.out.println("栈为空，无元素取出！");
            return null;
        }
        return (T) elementData[--currrentSize] ;
    }

    @Override
    public Object peek() {
        if(isEmpty()) {
            System.out.println("栈为空，无元素取出！");
            return null;
        }
        return elementData[currrentSize - 1];
    }

    @Override
    public int getSize() {
        return currrentSize;
    }

    @Override
    public boolean isEmpty() {
        return currrentSize == 0;
    }
}
