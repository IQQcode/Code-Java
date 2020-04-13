package iqqcode.algorithm.test;


import iqqcode.algorithm.sort.MergeSort;
import iqqcode.algorithm.sort.MergeSortMethod;
import org.junit.Test;

import java.util.Arrays;

import static iqqcode.algorithm.sort.MergeSort.mergeSort;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-10 09:54
 * @Description:
 */
public class TestMergeSort {
    @Test
    public void testMergeSortMethod() {
        Integer[] data = {4,6,8,7,9,2,10,1};
        MergeSortMethod.mergeSortMethod(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testMergeSort() {
        int[] data = {4,6,8,7,9,2,10,1};
        MergeSort.mergeSort(data);
        System.out.println(Arrays.toString(data));
    }
}
