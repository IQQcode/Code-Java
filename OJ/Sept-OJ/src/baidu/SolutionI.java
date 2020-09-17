package sept14.baidu;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-09-14 23:08
 * @Description: 百度笔试题一
 *
 * 【字符串】: 去除字符串中 连续的字符(含空格)
 *
 * [输入]
 * DDDDoo yooouu lllovvvvvvvvvvve                 mmmmee
 *
 * [输出]
 * Do you love me
 */

public class SolutionI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //String str = "DDDDoo yooouu lllovvvvvvvvvvve                 mmmmee";
        System.out.println(removeRepeat(str));
    }

    private static String removeRepeat(String str) {
        String[] ss = str.split("");
        List<String> list = new ArrayList<> ();
        list.add(ss[0]);
        //[D, o,  , y, o, u,  , l, o, v, e,  , m, e]
        for (int i = 1; i < ss.length; i++) {
            if(!ss[i].equals(ss[i-1]))  {
                list.add(ss[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
