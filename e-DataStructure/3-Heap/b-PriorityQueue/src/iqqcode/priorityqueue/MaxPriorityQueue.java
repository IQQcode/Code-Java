package iqqcode.priorityqueue;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-24 09:38
 * @Description:最大优先队列
 */
public class MaxPriorityQueue<T extends Comparable> {
    //存储堆中的元素
    private final T[] element;
    //记录堆中元素个数
    private int N;

    public MaxPriorityQueue(int capacity) {
        //element[0]不存储元素,下标从1开始，符合堆的性质
        this.element = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * 获取队列中的元素个数
     *
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     *
     * @param i
     * @param j
     * @return
     */
    public boolean less(int i, int j) {
        return element[i].compareTo(element[j]) < 0;
    }

    /**
     * 交换索引i和索引j处的值
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        T temp = element[i];
        element[i] = element[j];
        element[j] = temp;
    }

    /**
     * 向堆中插入元素
     *
     * @param data
     */
    public void add(T data) {
        //为了方便操作，element[0]处不存储元素(故为++N)
        element[++N] = data;
        rise(N);
    }

    /*
     * 删除堆中最大的元素，并返回删除值
     */
    public T remove() {
        T max = element[1];
        //堆顶元素root和末尾节点node(最大索引处)交换，让末尾节点变为完全二叉树临时根节点
        swap(1, N);
        //删除最大索引处的末尾节点(root)
        element[N] = null;
        //元素个数-1
        N--;
        //通过下沉调整堆，让堆有序
        /*此处调整的是临时根节点node，保证大顶堆有序*/
        sink(1);
        return max;
    }

    /**
     * 使用上浮算法：使索引index处的元素能在堆中处于正确的位置
     * @param index
     */
    public void rise(int index) {
        //通过迭代，不断地比较当前节点和其父节点值的大小; 如果父节点值比当前节点小，则交换位置(大顶堆)
        while (index > 1) {
            //比较当前节点和其父节点
            if (less(index / 2, index)) {
                swap(index / 2, index);
            }
            index = index / 2;
        }
    }

    /**
     * 使用下沉算法：使索引index处的元素能在堆中处于正确的位置
     * @param index
     */
    public void sink(int index) {
        //通过循环比较当前节点index和其左子节点(2k)、右子节点(2k+1)中较大值; 如果当前节点小，需要交换位
        while (2 * index <= N) {
            //获取当前节点中较大的孩子节点
            int max = 0; //记录较大节点处的索引
            /*当前节点有左右孩子*/
            if (2 * index + 1 <= N) {
                if (less(2 * index, 2 * index + 1)) {
                    max = 2 * index + 1;
                } else {
                    max = 2 * index;
                }
            } else {
                /*当前节点只有一个孩子节点*/
                max = 2 * index;
            }

            //如果index的值均大于左右节点
            if (!less(index, max)) {
                break;
            }

            //如果index的值小于左节点或右节点
            swap(index, max);
            //更新index
            index = max;
        }
    }
}
