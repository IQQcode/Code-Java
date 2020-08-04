package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-04 17:24
 * @Description:桶排序
 * https://mp.weixin.qq.com/s?src=11&timestamp=1596531927&ver=2502&signature=ESvLLPbOTAZYXEHvsPZEhLq6GjEt0LHVFRX-i-9xrkXS0DPLAWt7PTX4K1Z-ShBrza29fb2W-mpLYWIqSz6YomtRZjIsAUhejSiFUZqDDz4QEzLqJjIy3myqbl9mddQy&new=1
 */
public class BucketSort {
    public static double[] bucketSort(double[] array) {
        //1.得到数列的最大值和最小值，并算出差值d
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;
        //2.初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }
        //3.遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }
        //4.对每个通内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            //JDK底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }
        //5.输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]{4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
