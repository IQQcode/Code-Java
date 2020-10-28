import java.util.Arrays;
import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-10-19 09:55
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        int numStr = n / 3 * m;
        String[] strs = new String[numStr];
        char[][] chars = new char[numStr][5];
        char[][] map = new char[m][n];
        for (int i = 0; i < numStr; i++) {
            strs[i] = in.next();
            chars[i] = strs[i].toCharArray();
        }
        int k = 0;
        for (int i = 0, j = 0; i < m; i++,j++) {
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
