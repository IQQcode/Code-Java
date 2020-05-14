package iqqcode.algorithm.test;


import iqqcode.algorithm.sort.BasicBubbleMaethod;
import org.junit.Test;

import java.util.Arrays;

import static iqqcode.algorithm.sort.BasicBubbleSort.bubbleSort_toLarge;
import static iqqcode.algorithm.sort.BasicBubbleSort.bubbleSort_toSmall;
import static iqqcode.algorithm.sort.CocktailSort.cocktailSort;
import static iqqcode.algorithm.sort.OptimalBubble.optimalBubble;
import static iqqcode.algorithm.sort.OptimalBubblePlus.optimalBubblePlus;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-09 14:59
 * @Description:
 */
public class BubbleTest {
    @Test
    public void test_toLarge() {
        int[] array = new int [] {5, 8, 6, 3, 9, 2, 1, 7};
        bubbleSort_toLarge(array);
        System.out.println("Small toLarge BubbleSort is : " + Arrays.toString(array));
    }

    @Test
    public void test_toSmall() {
        int[] array = new int [] {5, 8, 6, 3, 9, 2, 1, 7};
        bubbleSort_toSmall(array);
        System.out.println("Large toSmall BubbleSort is : " + Arrays.toString(array));
    }

    @Test
    public void testMethod() {
        Integer[] arr = {4, 5, 6, 3, 2, 1};
        BasicBubbleMaethod.bubbleSort_CompareTo(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testOptimalBubble() {
        int[] array = new int [] {5, 8, 6, 3, 9, 2, 1, 7};
        optimalBubble(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testOptimalBubblePlus() {
        int[] array = new int [] { 3, 4, 2, 1, 5, 6, 7, 8 };
        optimalBubblePlus(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testcocktailSort() {
        int[] array = new int [] {2, 3, 4, 5, 6, 7, 8, 1};
        cocktailSort(array);
        System.out.println(Arrays.toString(array));
    }
}
