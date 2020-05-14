package iqqcode.algorithm.sort;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-28 11:43
 * @Description:堆排序
 * data = {3, 4, 6, 9, 2, 8}
 */
public class HeapSort {

    /**
     * 堆排序
     * 1.构建堆 buildHeap()
     * 2.对堆进行排序 heapSort()
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //先构建堆
        buildHeap(arr);
        //从末尾出发，开始排序
        for (int i = arr.length - 1; i >= 0; i--) {
            //交换堆顶和末尾节点(包含了砍断操作)
            swap(arr, i, 0);
            //树的节点数len是不断减少的(不断在砍断)，i代表当前数的节点个数； len == i
            heapify(arr, i, 0);
        }
    }

    /**
     * 构建大顶堆
     * @param arr
     */
    public static void buildHeap(int[] arr) {
        //该树的最后一个节点
        int last_node = arr.length - 1;
        //最后一个节点的父亲节点
        int parent = (last_node - 1) / 2;
        //自底向上对父亲节点做 hepify
        for (int i = parent; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    /**
     * 确保当前父节点大于左右子节点
     * @param data 待排序数组
     * @param len 树的节点个数
     * @param root 当前子树的根节点
     */
    public static void heapify(int[] data, int len, int root) {
        //递归的出口，当前根节点位置超出了树的范围
        if(root >= len) {
            return;
        }
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int max = root; //子树节点最大值
        //当前父节点有右孩子，并且父节点小于右子树
        if (right < len && data[max] < data[right]) {
            max = right;
        }
        //当前父节点有左孩子，并且父节点小于左子树
        if (left < len && data[max] < data[left]) {
            max = left;
        }
        //找到了左右子树中的最大值，与父亲节点交换
        if (max != root) { //如果父节点均大于子树，则不用交换
            swap(data, max, root);            //继续对其下面的子树构建
            heapify(data, len, max);
        }
    }

    /**
     * 交换数字
     * @param data
     * @param i
     * @param j
     */
    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
