package iqqcode.test;

import iqqcode.heap.Heap;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-19 22:04
 * @Description:
 */
public class HeapTest {
    @Test
    public void test() {
        Heap<String> heap = new Heap<>(10);
        heap.add("A");
        heap.add("B");
        heap.add("C");
        heap.add("D");
        heap.add("E");
        heap.add("F");
        heap.add("G");
        String result = null;
        while ((result = heap.remove()) != null) {
            System.out.print(result + " ");
        }
    }
}
