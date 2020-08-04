package test;

import sort.HeapSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-28 12:19
 * @Description:
 */
public class HeapSortTest {
    @Test
    public void test() {
        int[] arr = {3, 4, 6, 9, 2, 8};
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
