package qihu360;

/**
 * @Author: iqqcode
 * @Date: 2020-09-26 17:56
 * @Description: 搬家公司正在帮助一家人将小物体装箱。一个箱子的大小是有限的，公司可以把一个箱子分成最多k个独立的隔间，
 * 将一个箱子分成r个隔间需要r-1个隔板（这一个箱子没有放隔板也拥有一个本身的隔间）。
 * 而这一次搬家工作只携带了b个隔板。在每一个隔间中，由于物件放多了容易损坏，最多只能放v个物体。
 * 现在这家人有a个物体，请问最少需要多少个箱子，才能将所有的物体装箱？
 * <p>
 * 多组数据，每一行一组数据包含4个数，a,b,k,v,空格隔开
 * <p>
 * 输出包含一个数，即最少的箱子数
 * <p>
 * 10 3 2 1
 * 10 3 2 2
 * <p>
 * 7
 * 3
 * <p>
 * 范围：1<=a,b,k,v<=100000，数据组数不会超过1000组
 * 样例解释：
 * 对于样例1，第1,2,3个箱子分成两个隔间，使用掉了3个隔板，装了6个物件。第4,5,6,7个箱子没有使用隔板，装了4个物件。共7个箱子装完了所有物件。
 * 对于样例2，第1,2个箱子分成两个隔间，使用掉了2个隔板，装了8个物件，最后两个物件装在第三个箱子中。
 */

import java.util.*;

public class Solution {
    /**
     * @param box 物体数
     * @param ge    隔板数 (r个隔间需要r-1个隔板)
     * @param div   一个箱子分成最多k个独立的隔间
     * @param take  每个隔间放的数目
     * @return 最少的箱子数
     */
    public static int divide(int box, int ge, int div, int take) {
        int count = 0; //隔间数
        while(ge > 0) {
            if(ge < div) {
                box -= (ge + 1) * take;
                count++;
                break;
            } else {
                box -= div * take;
                count += 1;
                ge -= (div - 1);
                if(box <= 0) {
                    break;
                }
            }
        }
        while (box > 0) {
            box -= take;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int box = in.nextInt();
            int ge = in.nextInt();
            int div = in.nextInt();
            int take = in.nextInt();
            System.out.println(divide(box, ge, div, take));
        }
    }
}
