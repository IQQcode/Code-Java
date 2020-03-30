/*
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

    public static void bigger(int[] arr) {  //方法修改数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
            System.out.println(arr[i]);
        }
    }

}
*/

/*
public class Class2 {
    public static void main(String[] args) {
        int[] data1 = new int[] {11,99,66,33,5,88,2,0};
        int[] data2 = new int[] {1,2,3,4,5,6};
        char[] data3 = new char[] {'a','z','g','呵'};
        //1.数组排序---java.util.Arrays.sort();
        java.util.Arrays.sort(data1);
        java.util.Arrays.sort(data3);
        printArray(data1);
        printArray(data3);

        //2.数组内容拷贝---System.arraycopy(_,_,_,_,_);
        System.arraycopy(data1,3,data2,2,4);
        printArray(data2);

        //3.数组扩容---java.util.Array.copyOf();
        char[] exPend = java.util.Arrays.copyOf(data3,10);
        printArray(data3);
    }
    public static void printArray(int[] arr) {
        for(int i = 0;i < arr.length;i++) {
            System.out.print(arr[i]+"、");
        }
        System.out.println();
    }

    public static void printArray(char[] arr) {
        //方法重载:
        //   方法名称相同，参数的类型，顺序或个数不同；与返回值无关
        for(int i = 0;i < arr.length;i++) {
            System.out.print(arr[i]+"、");
        }
        System.out.println();
    }
}
*/




//Java数组章节练习题
public class Class2{

    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
        int max = data[0];
        for(int i =0;i < data.length;i++) {
            if(data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
        int min = data[0];
        for(int i =0;i < data.length;i++) {
            if(min > data[i]) {
                min = data[i];
            }
        }
        return min;
    }


    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        int sum = 0;
        for(int i =0;i < data.length;i++) {
            sum += data[i];
        }
        return sum;
    }

    //4.数组拼接
    // A {1,3,5,7,9} B {2,4,6,8,10} -> {1,3,5,7,9,2,4,6,8,10}
    public static int[] arrayJoin(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        for(int i = 0;i < a.length; i++) {
            result[i] = a[i];
        }

        for(int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i];
        }
        System.out.println();
        return result;
    }

    //5.数组截取
    //[start, end)
    // A {1,3,5,7,9} ->(A,1,3) > {3,5}
    public static int[] arraySub(int[] data, int start , int end){
        int[] result = new int[end - start];
        int flag = 0;
        for(int i =start; i < end; i++) {
            result[flag] = data[i];
            flag++;
        }
        System.out.println();
        return result;
    }

    //6.数组打印
    public static void printArray(int[] data){
        for(int i : data) {
            System.out.print( i + "、");
        }
    }

    //7.数组反转
    public static void printReversal(int[] data){

    }

    public static void main(String[] args){
        int[] data = new int[] {1,3,5,7,9};
        System.out.println(arrayMaxElement(data));
        System.out.println(arrayMinElement(data));
        System.out.println(arrayElementSum(data));
        printArray(data);

        //4.数组拼接
        int[] a = null;
        a = data;   //引用传递
        int[] b = new int[] {2,4,6,8,10,12};
        int[] result = arrayJoin(a,b);
        printArray(result);

        //5.数组截取
        int[] consequence = arraySub(b,1,4);
        printArray(consequence);


    }
    }

