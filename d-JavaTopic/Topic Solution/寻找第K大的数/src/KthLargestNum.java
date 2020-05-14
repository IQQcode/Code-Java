import java.util.Arrays;

/**
 * 按如下步骤在n个元素里面第K大的元素：
 * 由小到大进行非完全快排
 * 第一步：进行一次快排（将大的元素放在前半段，小的元素放在后半段）,得到的中轴p
 * 第二步：判断 p - low + 1 == k ，如果成立，直接返回a[p]，（前半段有p - low（等于k-1）个大于a[p]元素，则a[p]为第K大的元素）
 * 第三步：如果 p - low + 1 > k，则第k大的元素在前半段，更新high = p - 1，执行第一步
 * 第四步：如果 p - low + 1 < k，则第k大的元素在后半段，更新low = p + 1, 且 k = k - (p - low + 1)，执行第一步
 *
 * 常规快排得到整体有序的数组复杂度是O(nlgn)，此方法每次可以去掉“一半”的元素，复杂度为O(n)。
 * @K值为要求的数
 */
public class KthLargestNum {
    public static void main(String[] args) {
        int[] arr = new int[] {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(findKth(arr,arr.length,3));
    }

    public static int findKth(int[] a, int n, int K) {
        return quickSort(a,0,n - 1,K);
    }

    private static int quickSort(int[] arr, int low, int high, int K) {
        //中轴p
        int p = partion(arr,low,high);
        if(K == p - low + 1){
            return arr[p];
        }else if(p - low + 1 > K){
            //递归左边
            return quickSort(arr,low,p-1,K);
        }else{
            //递归右边
            return quickSort(arr,p+1,high,K-(p-low+1));
        }
    }

    private static int partion(int[] arr, int low, int high) {
        int tmp = arr[low];
        while(low < high){
            while(low < high && arr[high] <= tmp) {
                high--;
            }
            if(low == high) {
                break;
            }else{
                arr[low] = arr[high];
            }
            while(low < high && arr[low] >= tmp) {
                low++;
            }
            if(low == high) {
                break;
            }else {
                arr[high] = arr[low];
            }
        }
        arr[low] = tmp;
        return low;
    }
}
