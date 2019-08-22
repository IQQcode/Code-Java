package com.DynamicArray;


import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-22 20:07
 * @Description:实现动态数组
 */
class MyArray<E> {
    private E[] elementData; //实际存放元素的数组
    private final static int DEFAULT_SIZE = 10; //默认的初始容量
    private int size; //实际容量

    public MyArray() {
        //无参构造调用第一个有参构造
        this(DEFAULT_SIZE);
    }
    public MyArray(int initCap) {
        this.elementData = (E[]) new Object [initCap];
    }
    public void add(E e) {
        if(size == elementData.length) {  //此时数组已达到默认的初始容量
            int oldCap = elementData.length;
            // DEFAULT_SIZE < 64,扩容2倍; DEFAULT_SIZE > 64,扩容1.5倍
            int newCap = oldCap + ((size < 64) ? oldCap : oldCap >> 1);
            if(newCap > Integer.MAX_VALUE - 8) {
                throw new IllegalArgumentException("Array element too many！！");
            }
            elementData = Arrays.copyOf(elementData, newCap);
        }
        elementData[size++] = e;
    }
}

public class ArrayOfDynamicArray {
    public static void main(String[] args) {

    }
}
