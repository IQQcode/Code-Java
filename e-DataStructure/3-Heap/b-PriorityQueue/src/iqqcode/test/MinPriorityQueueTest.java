package iqqcode.test;


import iqqcode.priorityqueue.MinPriorityQueue;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-24 09:57
 * @Description:test
 */
public class MinPriorityQueueTest {
    @Test
    public void test() {
        MinPriorityQueue<Integer> minPriority = new MinPriorityQueue<>(10);

        minPriority.add(9);
        minPriority.add(3);
        minPriority.add(2);
        minPriority.add(5);
        minPriority.add(1);
        minPriority.add(8);
        minPriority.add(6);

        System.out.print("循环获取堆中最小元素:\t");
        while(!minPriority.isEmpty()) {
            int min = minPriority.remove();
            System.out.print(min + " ");
        }
    }
}