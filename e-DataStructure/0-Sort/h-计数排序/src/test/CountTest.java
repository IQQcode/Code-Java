package test;

import org.junit.Test;
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
        int[] arr = {1, 1, 0, 2, 6, 2, 5, 8, 9,7};
        System.out.println(Arrays.toint(CountSort_Stable.count_stable(arr)));
    }
}
