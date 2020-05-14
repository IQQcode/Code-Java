package www.javaSE;

public class javaTest1 {
    public static void main(String[] agrs) {
        int a[][] = {{2,1,3,6,9},{27,18,34}};
        int b[][];
        System.out.println("The array a is");
        showArray(a);
        b = addArray(a);
        System.out.println("The array b is");
        showArray(b);
    }

    public static int[][] addArray(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0;j<a[i].length; j++) {
                a[i][j]++;
            }
        }
        return a;  //返回 a的引用地址，栈内存指向
    }

    public static void showArray(int[][] a) {
        for(int i = 0;i < a.length;  i++) {
            for(int j = 0;j < a[i].length; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.println("");
        }
    }
}
