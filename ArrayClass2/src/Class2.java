public class Class2 {
    public static void main(String[] args) {
        int[] data = init();
        printArray(data);   //引用传递
        bigger(data);
    }

    public static void printArray(int[] temp) {   //方法接收数组；
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

    public static int[] init() {    //方法返回数组
        return new int[]{1, 2, 3, 4, 5, 6};   //匿名数组；
    }

    public static void bigger(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
            System.out.println(arr[i]);
        }
    }
}
