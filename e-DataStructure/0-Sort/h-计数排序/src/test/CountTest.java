package test;

import org.junit.Test;
import sort.CountSort;
import sort.CountSort_Stable;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-04 12:11
 * @Description:
 */
public class CountTest {
    @Test
    public void test() {
        int[] arr = {10, 10, 15, 20, 16, 12, 15, 18, 19, 17};
        System.out.println(Arrays.toString(CountSort.count(arr)));
    }
}
