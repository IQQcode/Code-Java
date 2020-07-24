package iqqcode.heap;

import	java.util.Comparator;
import org.junit.Test;
import java.util.PriorityQueue;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-19 23:29
 * @Description:PriorityQueue-API实现堆
 * 默认最小堆，最大堆后面减前面
 */
public class HeapAPITest {
    /**
     * 默认小顶堆
     */
    @Test
    public void test() {
        int[] arr = {1, 3, 6, 4, 10, 8, 5, 7};
        //默认实现的是最小堆，元素按照自然排序(数字的从小到大)
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            heap.offer(arr[i]);
        }

        while(!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
    }

    /**
     * 通过比较器排序，实现最大堆
     */
    @Test
    public void tests() {
        int[] arr = {1, 3, 6, 4, 10, 8, 5, 7};
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer> () {

            @Override
            public int compare(Integer o1, Integer o2) {
                //写成return o1.compareTo(o2) 或者 return o1-o2表示升序
                //写成return o2.compareTo(o1) 或者return o2-o1表示降序
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            heap.offer(arr[i]);
        }

        while(!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
    }
}
