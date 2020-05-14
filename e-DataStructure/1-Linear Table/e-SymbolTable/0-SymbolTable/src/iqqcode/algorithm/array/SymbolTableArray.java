package iqqcode.algorithm.array;


/**
 * @Author: Mr.Q
 * @Date: 2020-05-14 11:43
 * @Description:数组实现符号表
 * 参考链接：https://www.jianshu.com/p/ad86f65f081d
 */
public class SymbolTableArray<Key extends Comparable<Key>,Value> {
    private Key[] keys; //键数组
    private Value[] values; //值数组
    private int N; //记录符号表中元素个数

    public SymbolTableArray(int len) {
        this.keys = (Key[]) new Comparable[len];
        this.values = (Value[]) new Object[len];
        N = 0;
    }

    /**
     * 记录符号表中键值对的个数
     * @return
     */
    public int size() {
        return this.N;
    }

    //符号表中插入键值对
    public void put(Key key, Value value) {
        //根据键找到该键位于键数组中的索引位置
        int target = rank(key);
        //如果已经存在了键，就覆盖
        if (target < N && keys[target].compareTo(key) == 0) {
           values[target] = value;
           return;
        }
        // 不存在，先将数组腾出空间，然后插入
        for (int i = N; i > target; i++) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[target] = key;
        values[target] = value;
        N++;
    }

    //删除符号表中键为key的键值对
    public void delete(Key key) {
        //根据键找到该键位于键数组中的索引位置
        int target = rank(key);
        if (target == N || keys[target].compareTo(key) != 0) {
            return;
        }
        for (int i = target; i < N - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        keys[N] = null;
        values[N] = null;
        N--;
    }

    /**
     * 获取键为key的value值
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (N == 0) {
            return null;
        }
        //根据键找到该键位于键数组中的索引位置
        int target = rank(key);
        if (target < N && keys[target].compareTo(key) == 0) {
            return values[target];
        }
        return null;
    }

    /**
     * 根据key找出value(根据索引[key]进行二分查找)
     * @param key
     * @return
     */
    public int rank(Key key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int temp = key.compareTo(keys[mid]);
            if (temp == 0) {
                return mid;
            }else if (temp < 0) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
