package iqqcode.test;

import iqqcode.priorityqueue.MaxPriorityQueue;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-24 09:57
 * @Description:test
 */
public class MaxPriorityQueueTest {
    @Test
    public void test() {
        MaxPriorityQueue<Integer> maxPriority = new MaxPriorityQueue<>(10);

        maxPriority.add(1);
        maxPriority.add(3);
        maxPriority.add(2);
        maxPriority.add(5);
        maxPriority.add(9);
        maxPriority.add(8);
        maxPriority.add(6);

        System.out.print("循环获取堆中最大元素:\t");
        while(!maxPriority.isEmpty()) {
            int max = maxPriority.remove();
            System.out.print(max + " ");
        }
    }
}