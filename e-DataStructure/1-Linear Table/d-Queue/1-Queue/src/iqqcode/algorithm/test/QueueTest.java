package iqqcode.algorithm.test;

import iqqcode.algorithm.queue.ArrayQueue;
import iqqcode.algorithm.queue.LinkQueue;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-10 14:56
 * @Description:队列测试
 */
public class QueueTest {
    @Test
    public void testLinkQueue() {
        LinkQueue<String> que = new LinkQueue<> ();
        que.enQueue("Java");
        que.enQueue("Python");
        que.enQueue("C++");
        que.enQueue("Go");
        que.enQueue("JavaScript");
        for (String s : que) {
            System.out.println(s);
        }
        System.out.println("出队元素是： " + que.outQueue());
        System.out.println("当前队列元素个数为： " + que.size());
        System.out.println("当前队首元素是： " + que.peek());
        System.out.println("当前队尾元素是： " + que.end());
    }

    @Test
    public void testArrayQueue() {
        ArrayQueue<String> que = new ArrayQueue<> (10);
        que.enQueue("Java");
        que.enQueue("Python");
        que.enQueue("C++");
        que.enQueue("Go");
        que.enQueue("JavaScript");
        for (Object o : que) {
            System.out.println(o);
        }
        System.out.println("出队元素是： " + que.outQueue());
        System.out.println("当前队列元素个数为： " + que.size());
        System.out.println("当前队首元素是： " + que.peek());
        System.out.println("当前队尾元素是： " + que.end());
    }
}
