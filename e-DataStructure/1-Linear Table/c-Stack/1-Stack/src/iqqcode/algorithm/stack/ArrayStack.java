package iqqcode.algorithm.stack;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-09 15:56
 * @Description:基于数组--栈
 */
public class ArrayStack<T> implements Iterable<Object> {

    //存放数据
    private Object[] elements;
    //最大元素个数
    private int maxsize;
    //当前栈中元素个数
    private int N;

    //初始化数组
    public ArrayStack(int maxsize) {
        this.maxsize = maxsize;
        elements = new Object[maxsize];
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return  N == 0;
    }

    /**
     * 栈中元素个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 扩容栈
     * @param o 压栈元素
     * @return
     */
    public boolean push(T t) {
        //栈已满，需要扩容
        if (N == maxsize) {
            int oldSize = maxsize;
            int newSize = maxsize << 1; //两倍扩容
            if(newSize + 1 > Integer.MAX_VALUE) {
                System.err.println("栈已达到最大扩容,无法继续扩容！！！");
                return false;
            }
            maxsize = newSize;
            //将扩容前的数组拷贝到新数组中
            elements = Arrays.copyOf(elements,maxsize);
        }
        elements[N++] = t;
        return true;
    }

    /**
     * 弹栈
     * @return
     */
    public T pop() {
        if(isEmpty()) {
            System.err.println("栈为空，无元素取出！");
            return null;
        }
        return (T) elements[--N];
    }

    /**
     * 栈顶元素
     * @return
     */
    public T peek() {
        if(isEmpty()) {
            System.err.println("栈为空，无元素取出！");
            return null;
        }
        return (T) elements[N - 1];
    }

    /**
     * 提供遍历方式
     * @return
     */
    @Override
    public Iterator<Object> iterator() {
        return new Iterator () {

            private int current;

            @Override
            public boolean hasNext() {
                return current < N;
            }

            @Override
            public Object next() {
                return elements[current++];
            }
        };
    }
}
