package iqqocde.algorithm.test;

import iqqocde.algorithm.sort.ShellSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-12 11:23
 * @Description:希尔排序测试类
 */
public class ShellSortTest {
    /**
     * 希尔排序
     */
    @Test
    public void testShellSort() {
        Integer[] data = new Integer[] {9,1,2,5,7,4,8,6,3,5};
        ShellSort.shellSort(data);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 插入排序
     */
    @Test
    public void testInsertSort() {
        Integer[] data = new Integer[] {9,1,2,5,7,4,8,6,3,5};
        InsertSort.insertSort(data);
        System.out.println(Arrays.toString(data));
    }
}