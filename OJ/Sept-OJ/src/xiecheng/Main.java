package xiecheng;

/**
 * @Author: iqqcode
 * @Date: 2020-10-13 09:00
 * @Description:携程笔试
 * 需要可乐的数量为 m
 * 10元的张数为 a
 * <p>
 * 50元的张数为 b
 * <p>
 * 100元的张树为 c
 * <p>
 * 1瓶可乐的价格为 x
 * <p>
 * 2
 * 1
 * 4
 * 3
 * 250
 *
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 游游今年就要毕业了，和同学们在携程上定制了日本毕业旅行。愉快的一天行程结束后大家回到了酒店房间，这时候同学们都很口渴，石头剪刀布选出游游去楼下的自动贩卖机给大家买可乐。
 *
 * 贩卖机只支持硬币支付，且收退都只支持10 ，50，100 三种面额。一次购买行为只能出一瓶可乐，且每次购买后总是找零最小枚数的硬币。（例如投入100圆，可乐30圆，则找零50圆一枚，10圆两枚）
 *
 * 游游需要购买的可乐数量是 m，其中手头拥有的 10,50,100 面额硬币的枚数分别是 a,b,c，可乐的价格是x(x是10的倍数)。
 *
 * 如果游游优先使用大面额购买且钱是够的情况下,请计算出需要投入硬币次数？
 *
 *
 *
 * 输入描述
 * 依次输入，
 *
 * 需要可乐的数量为 m
 *
 * 10元的张数为 a
 *
 * 50元的张数为 b
 *
 * 100元的张树为 c
 *
 * 1瓶可乐的价格为 x
 *
 * 输出描述
 * 输出当前金额下需要投入硬币的次数
 *
 * 例如需要购买2瓶可乐，每瓶可乐250圆，手里有100圆3枚，50圆4枚，10圆1枚。
 *
 * 购买第1瓶投递100圆3枚，找50圆
 *
 * 购买第2瓶投递50圆5枚
 *
 * 所以是总共需要操作8次金额投递操作
 *
 *
 * 样例输入
 * 2
 * 1
 * 4
 * 3
 * 250
 * 样例输出
 * 8
 *
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int m;
        m = Integer.parseInt(in.nextLine().trim());

        int a;
        a = Integer.parseInt(in.nextLine().trim());

        int b;
        b = Integer.parseInt(in.nextLine().trim());

        int c;
        c = Integer.parseInt(in.nextLine().trim());

        int x;
        x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(m, a, b, c, x);
        System.out.println(String.valueOf(res));
    }

    private static int buyCoke(int m, int a, int b, int c, int x) {
        int[] coins = {10, 50, 100};
        int[] num = {a, b, c};
        int total = m * x;
        int[] dp = new int[ total + 1];
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = m; j > coins[i] -1 ; j--) {
                for (int k = 1; k < num[i] + 1; k++) {
                    if(j >= k * coins[i]) {
                        dp[j] = Math.min(dp[j], dp[j - k * coins[i]] + k);
                    }
                }
            }
        }
        return dp[total];
    }
}
