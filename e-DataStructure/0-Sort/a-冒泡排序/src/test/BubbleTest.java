package test;


import org.junit.Test;
import sort.BasicBubble;
import sort.Bubble_Border;
import sort.Bubble_Flag;
import sort.CocktailSort;

import java.util.Arrays;


/**
 * @Author: Mr.Q
 * @Date: 2020-04-09 14:59
 * @Description:
 */
public class BubbleTest {
    @Test
    public void test_toLarge() {
        int[] array = new int [] {5, 8, 6, 3, 9, 2, 1, 7};
        BasicBubble.bubbleSort_toLarge(array);
        System.out.println("Small toLarge BubbleSort is : " + Arrays.toString(array));
    }

    @Test
    public void testBubble_Border() {
        int[] array = new int [] {5, 8, 6, 3, 9, 2, 1, 7};
        Bubble_Border.bubble_Border(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testBubble_Flag() {
        int[] array = new int [] { 3, 4, 2, 1, 5, 6, 7, 8 };
        Bubble_Flag.bubble_Flag(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testcocktailSort() {
        int[] array = new int [] {2, 3, 4, 5, 6, 7, 8, 1};
        CocktailSort.cocktailSort(array);
        System.out.println(Arrays.toString(array));
    }
}
