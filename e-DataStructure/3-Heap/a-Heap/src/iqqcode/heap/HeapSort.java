package iqqcode.heap;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-20 09:50
 * @Description:堆排序
 */
public class HeapSort {
    /**
     * 堆排序
     * @param element
     */
    public static void heapSort(int[] element) {
        buildHeap(element);
        for (int i = element.length - 1; i >= 0; i--) {
            swap(element, i, 0);
            heapify(element, i, 0);
        }
    }

    /**
     * 构建堆
     * @param element
     */
    public static void buildHeap(int[] element) {
        //该树的最后一个节点
        int last_node = element.length - 1;
        //最后一个节点的父亲节点
        int parent = (last_node / 2 - 1);
        //自底向上对父亲节点做 hepify
        for (int i = parent; i >= 0; i--) {
            heapify(element, element.length, i);
        }
    }

    /**
     * 调整堆
     * @param element
     * @param N 堆中元素个数
     * @param root
     */
    public static void heapify(int[] element, int N, int root) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int max = root;
        //当前父节点有孩子，并且父节点小于左孩子或孩子
        if(left < N && element[max] < element[left]) {
            max = left;
        }
        if(right < N && element[max] < element[right]) {
            max = right;
        }
        /*如果父节点均大于子树，则不用交换;不执行此处的if条件*/
        //继续对其下面的子树构建
        if(max != root) {
            swap(element, max, root);
            heapify(element, N, max); //root = max
        }
    }

    /**
     * 交换值
     * @param element
     * @param i
     * @param j
     */
    public static void swap(int[] element, int i, int j) {
        int temp = element[i];
        element[i] = element[j];
        element[j] = temp;
    }
}
