package iqqcode.algorithm.test;


import org.junit.Test;

import java.util.Arrays;

import static iqqcode.algorithm.sort.BasicBubble.bubbleSort_toLarge;
import static iqqcode.algorithm.sort.BasicBubble.bubbleSort_toSmall;
import static iqqcode.algorithm.sort.Bubble_Border.bubble_Border;
import static iqqcode.algorithm.sort.Bubble_Flag.bubble_Flag;
import static iqqcode.algorithm.sort.CocktailSort.cocktailSort;

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
    public void testBubble_Border() {
        int[] array = new int [] {5, 8, 6, 3, 9, 2, 1, 7};
        bubble_Border(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testBubble_Flag() {
        int[] array = new int [] { 3, 4, 2, 1, 5, 6, 7, 8 };
        bubble_Flag(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testcocktailSort() {
        int[] array = new int [] {2, 3, 4, 5, 6, 7, 8, 1};
        cocktailSort(array);
        System.out.println(Arrays.toString(array));
    }
}
