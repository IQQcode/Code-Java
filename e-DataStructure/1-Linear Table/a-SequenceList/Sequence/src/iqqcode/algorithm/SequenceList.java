package iqqcode.algorithm;

import java.util.Iterator;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-03 09:40
 * @Description:顺序表
 * 让SequenceList支持foreach循环，则需要：
 * 1.让SequenceList实现Iterable接口，重写iterator方法；
 * 2.在SequenceList内部提供一个内部类MIterator,实现Iterator接口，重写hasNext方法和next方法；
 */

public class SequenceList<T> implements Iterable<Object> {
    // 存储元素的数组
    private T[] elements;
    // 记录当前顺序表中的元素个数
    private int N;

    // 构造方法初始化
    public SequenceList(int capacity) {
        // 初始化数组
        this.elements = (T[]) new Object[capacity];
        // 初始化长度
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear() {
        this.N = 0;
    }

    /**
     * 判断当前线性表是否为空表
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取线性表中元素的个数
     * @return
     */
    public int length() {
        return N;
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public T get(int index) {
        return elements[index];
    }

    /**
     * 向线型表中添加元素t
     * @param t
     */
    public void insert(T t) {
        if (N == elements.length) {
            resize(2 * elements.length);
        }
        elements[N++] = t;
    }

    /**
     * 在index索引处插入元素t
     * @param index
     * @param t
     */
    public void insert(int index, T t) {
        if (N == elements.length) {
            resize(2 * elements.length);
        }
        // 先把index索引处的元素及其后面的元素依次向后移动一位(倒序遍历)
        for (int i = N; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        // 再把t元素放到index索引处即可
        elements[index] = t;
        // 元素个数+1
        N++;
    }

    /**
     * 删除指定位置index处的元素，并返回该元素
     * @param index
     * @return
     */
    public T remove(int index) {
        // 记录索引处index的值
        T current = elements[index];
        // 索引index后面元素依次向前移动一位即可
        for (int i = index; i < N-1; i++) {
            elements[i] = elements[i+1];
        }
        // 元素个数-1
        N--;
        //缩容
        if (elements.length < N / 4) {
            resize(elements.length / 2);
        }
        return current;
    }

    /**
     * 查找t元素第一次出现的位置
     * @param t
     * @return
     */
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (elements[i].equals(t)) {
                return i;
            }
        }
        return - 1;
    }

    /**
     * 根据参数newSize，重置线性表(扩容和缩容)
     * @param newSize
     */
    public void resize(int newSize) {
        // 定义一个临时数组，指向原数组
        T[] temp = elements;
        // 创建新数组
        elements = (T[]) new Object[newSize];
        // 把原数组的数据拷贝到新数组即可
        for (int i = 0; i < N; i++) {
            elements[i] = temp[i];
        }
    }

    /**
     * 顺序表遍历
     * @return
     */
    @Override
    public Iterator<Object> iterator() {
        return new MIterator();
    }

    private class MIterator implements Iterator {
        //私有指针指向当前语速
        private int cursor;
        
        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return elements[cursor++];
        }
    }
}

