package iqqcode.algorithm.test;


import iqqcode.algorithm.sort.HalfInsert;
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
    public void testInsertSort() {
        int[] data = {4,8,6,7,6,2,9,1};
        InsertSort.insertSort(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testHalfInsert() {
        int[] data = {4,8,6,7,6,2,9,1};
        HalfInsert.halfInsert(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testInsertSortMethod() {
        Integer[] data = {4,8,6,7,6,2,9,1};
        InsertSortMethod.insertSortMethod(data);
        System.out.println(Arrays.toString(data));
    }
}
