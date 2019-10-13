package com.linearlist.SequenceArray;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-13 12:47
 * @线性表——顺序表
 * @Description:实现顺序表接口
 */
public class SequenceArray implements ISequence{

    private Object[] elementData;
    //数组已使用空间
    private int usedSize;
    //数组默认值
    private static final int DEFAULT_CAPACITY = 10;

    public SequenceArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 判断数组是否已满
     * @return
     */
    private boolean isFull() {
        return this.usedSize == this.elementData.length;
    }
    /**
     * 1.判断pos的合法性，放入数据后是否会发生溢出
     * 2.向后移动数据
     * 3.插入数据,保证插入的位置有前驱
     * 4. usedSize++
     * @param pos 要插入位置的下标
     * @param data val插入值
     * @return
     */
    @Override
    public boolean add(int pos ,Object data) {
        //判断pos的合法性
        if(pos < 0 || pos > this.usedSize) {
            return false;
        }
        if(isFull()) {
            //如果数组已满,则动态扩容
            this.elementData = Arrays.copyOf(this.elementData,elementData.length * 2);
        }
        return false;
    }

    @Override
    public int contains(Object data) {
        return 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object newData) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.elementData,elementData.length * 2);
    }

    @Override
    public void clear() {

    }
}
