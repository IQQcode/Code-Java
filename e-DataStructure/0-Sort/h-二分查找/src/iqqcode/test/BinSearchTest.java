package iqqcode.test;

import iqqcode.search.BinarySearch;
import org.junit.Test;


/**
 * @Author: Mr.Q
 * @Date: 2020-05-20 09:53
 * @Description:
 */
public class BinSearchTest {
    @Test
    public void test() {
        int[] arr = {1,2,2,4,5,6,7,8};
        int key = 6;
        System.out.println(BinarySearch.binarySearch(arr , key));
    }
}
