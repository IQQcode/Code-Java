package www.Study;


public class BinarySearch {
    public static void main(String[] args) {
        //数组
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        //要查找的元素
        int key = 7;
        //第一个元素的下标
        int left = 0;
        //最后一个元素的下标
        int right = (arr.length - 1);
        //获取指定元素的下标
        int index = getSearch(arr, key, left, right);
        if(index == -1) {
            System.out.println("不含有该元素 "+ key);
        }else {
            System.out.println("含有该元素  "+ key + "，下标为："+ index);
        }
    }

    public static int getSearch(int[] arr, int key, int low, int high) {
        //求中间元素的下标
        int mid = (low + high) / 2;
        //数组内不含有指定元素，依据下标的规则，退出
        if (low > high)
            return -1;
        //查找到指定元素
        if (key == arr[mid]) {
            return mid;
            //当查找的元素大于中间下标的元素，则改变开始下标的位置
        } else if (key > arr[mid]) {
            return getSearch(arr, key, mid + 1, high);
        } else {
            //当查找的元素小于中间下标的元素，则改变结束下标的位置
            return getSearch(arr, key, low, mid - 1);
        }
    }


    public static int getSearch(int[] arr,int key,int left,int right) {

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(arr[mid] > key) {
                right = mid - 1;
            }else if(arr[mid] < key) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}




