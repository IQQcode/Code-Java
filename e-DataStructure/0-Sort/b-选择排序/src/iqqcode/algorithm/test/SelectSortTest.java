package iqqcode.algorithm.test;


import iqqcode.algorithm.sort.SelectSort;
import iqqcode.algorithm.sort.SelectSortMethod;
import org.junit.Test;

import java.util.Arrays;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-10 09:54
 * @Description:
 */
public class SelectSortTest {
    @Test
    public void testSelectSort() {
        int[] data = {4,6,8,7,6,2,9,1};
        SelectSort.selectSort(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testSelectSortMethod() {
        Integer[] data = {4,6,8,7,6,2,9,1};
        SelectSortMethod.selectSortMethod(data);
        System.out.println(Arrays.toString(data));
    }
}
