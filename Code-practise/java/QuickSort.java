
public class QuickSort {
    public static void main(String [] args) {
        int[] arr = new int[] {6,5,9,8,10,2,1,3,7};
        QuickSort1(arr,0,arr.length-1);
        System.out.print("The Result is: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr [i] + " ");
        }
    }

    public static void QuickSort1(int arr[],int left,int right) {
        if(left < right) {
            int temp = arr[0];
            int i = left;
            int j = right;
            while(left < right) {
                while (i < j && arr[j] > temp)
                    j--;
                if(i < j)
                    arr[i++] = arr[j];
                while(i < j && arr[i] < temp)
                    i++;
                if(i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = temp;  //基准数归位
            QuickSort1(arr,left,i - 1);
            QuickSort1(arr,i + 1,right);
        }
    }
}
