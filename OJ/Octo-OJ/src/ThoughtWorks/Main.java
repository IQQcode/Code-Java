package ThoughtWorks;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入地图 m-行 和 n-列: ");
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        //输入的字符串数量为：(n+2)/3*m; 4*6的为：(4+2)/3*4=8
        int numStr = (n + 2) / 3 * m;
        String[] strs = new String[numStr];
        char[][] chars = new char[numStr][5];
        char[][] map = new char[m][n];
        for (int i = 0; i < numStr; i++) {
            strs[i] = in.next();
            chars[i] = strs[i].toCharArray();
        }

        int k = 0;
        for (int i = 0, j = 0; i < m; i++, j++) {
            k = 0;
            map[j][k++] = chars[i][4];
            map[j][k++] = chars[i][0];
            map[j][k++] = chars[i][2];
        }
        for (int i = numStr - 1, j = 0; i >= m; i--, j++) {
            k = 3;
            map[j][k++] = chars[i][4];
            map[j][k++] = chars[i][0];
            map[j][k++] = chars[i][2];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
