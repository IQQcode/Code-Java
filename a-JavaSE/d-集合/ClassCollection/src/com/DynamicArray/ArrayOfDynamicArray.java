package com.DynamicArray;


import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-22 20:07
 * @Description:数组---实现动态数组扩容
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
            //将 oldCap 的内容拷贝到 newCap
            elementData = Arrays.copyOf(elementData, newCap);
        }
        elementData[size++] = e;
    }

    //查看指定索引值
    public E get(int index) {
        checkRange(index);
        return (E) elementData [index];
    }

    //设置指定索引值
    public void set(E element,int index) {
        checkRange(index);
        elementData[index] = element;
    }

    //索引合法判断 [0,size]
    public void checkRange(int index) {
        if(index < 0 || index > size - 1) {
            throw new IllegalArgumentException("index is error!!");
        }
    }

    @Override
    public String toString() {
        return "MyArray { " +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                " }";
    }
}

public class ArrayOfDynamicArray {
    public static void main(String[] args) {
        MyArray<String> msg = new MyArray<>();
        msg.add("SchoolStarts..");
        msg.add("大三了！！");
        msg.add("A");
        msg.add("B");
        msg.add("C");
        msg.add("D");
        System.out.println("下标为3的元素为: " + msg.get(3));
        msg.set("Mr.Q",5);
        System.out.println(msg);
    }
}
