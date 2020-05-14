package iqqocde.algorithm.test;

import iqqocde.algorithm.sort.MergeSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-13 08:45
 * @Description:归并排序测试
 */
public class MergeTest {
    @Test
    public void testMergeSort() {
        int[] data = new int[] {8,4,5,7,1,3,6,2};
        int left = 0;
        int right = data.length - 1;
        MergeSort.mergeSort(data, left, right);
        System.out.println(Arrays.toString(data));
    }
}
