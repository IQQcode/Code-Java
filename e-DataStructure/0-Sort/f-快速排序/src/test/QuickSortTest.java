package test;

import iqqcode.algorithm.sort.Quick;
import iqqcode.algorithm.sort.QuickSort;
import iqqcode.algorithm.sort.QuickSortMethod;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-13 11:12
 * @Description:快速排序测试
 */
public class QuickSortTest {

    @Test
    public void testQuick() {
        int[] data = new int[] { 6, 1, 2, 7, 9, 3, 4, 5, 10, 5 };
        Quick.quick(data, 0, data.length - 1);
        System.out.println("Quick 排序结果为：" + Arrays.toString(data));
    }

    @Test
    public void testQuickSort() {
        int[] data = new int[] { 6, 1, 2, 7, 9, 3, 4, 5, 10, 5 };
        QuickSort.quickSort(data, 0, data.length - 1);
        System.out.println("QuickSort 排序结果为：" + Arrays.toString(data));
    }

    @Test
    public void testQuickSortMethod() {
        int[] data = new int[] { 6, 1, 2, 7, 9, 3, 4, 5, 10, 5 };
        QuickSortMethod.quickSortMethod(data, 0, data.length - 1);
        System.out.println("QuickSortMethod 排序结果为：" + Arrays.toString(data));
    }
}
