package www.Algorithmic;

public class QuickSort {
    public static void main(String[] args) {
        System.out.print("数组元素为：");
        int[] arr = new int[] {6,1,2,7,9,3,4,5,10,8};
        for(int a = 0; a < arr.length; a++) {
            System.out.print(arr[a] + " ");
        }
        QuickSort(arr,0,arr.length - 1);
        System.out.print("\n排序结果为：");
        for(int i = 0; i < arr.length; i++)  {
            System.out.print(arr[i] + " ");
        }
    }

    public static void QuickSort(int[] arr,int left,int right) {
        if (left < right) {
            int temp = arr[left];
            int i = left;
            int j = right;
            while (i < j) {
                while(i < j && arr[j] > temp)
                    j--; // 从右向左找第一个小于x的数
                if(i < j)
                    arr[i++] = arr[j];
                while(i < j && arr[i] < temp)
                    i++; // 从左向右找第一个大于x的数
                if(i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = temp;
            QuickSort(arr, left, i-1);
            QuickSort(arr, i+1, right);
        }
    }
}

