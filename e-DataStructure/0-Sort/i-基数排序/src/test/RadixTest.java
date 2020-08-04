package test;

import org.junit.Test;
import sort.RadixSort;
import sort.RadixSort_String;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-04 14:14
 * @Description:
 */
public class RadixTest {
    @Test
    public void test() {
        int[] arr = {103, 9, 1, 7, 15, 25, 109, 209, 5};
        System.out.println(Arrays.toString(RadixSort.radixSort(arr)));
    }

    @Test
    public void testString() {
        String[] s = {"as", "effort", "hello", "tes", "a", "zwe"};
        int max_length = s[0].length();
        for (int i = 0; i < s.length; i++) {
            if(s[i].length() > max_length)
                max_length = s[i].length();
        }
        System.out.println(Arrays.toString(RadixSort_String.radixSort_String(s, max_length)));
    }
}
