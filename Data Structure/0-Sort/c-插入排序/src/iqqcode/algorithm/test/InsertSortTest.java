package iqqcode.algorithm.test;


import iqqcode.algorithm.sort.InsertSort;
import iqqcode.algorithm.sort.InsertSortMethod;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-10 11:07
 * @Description:
 */
public class InsertSortTest {
    @Test
    public void testInsertSortMethod() {
        Integer[] data = {4,6,8,7,9,2,10,1};
        InsertSortMethod.insertSortMethod(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testInsertSort() {
        int[] data = {4,6,8,7,9,2,10,1};
        InsertSort.insertSort(data);
        System.out.println(Arrays.toString(data));
    }
}
