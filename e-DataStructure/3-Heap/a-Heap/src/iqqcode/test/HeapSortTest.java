package iqqcode.test;

import iqqcode.heap.HeapSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-19 22:04
 * @Description:
 */
public class HeapSortTest {
    @Test
    public void test() {
        int[] element = {3, 4, 6, 9, 2, 8};
        HeapSort.heapSort(element);
        System.out.println(Arrays.toString(element));
    }
}
