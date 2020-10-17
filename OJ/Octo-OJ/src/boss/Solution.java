package boss;

/**
 * @Author: iqqcode
 * @Date: 2020-10-15 18:30
 * @Description:Bosszhi直聘
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 * ["192.168.1.1", "192.168.1.2", "192.168.1.3"],
 * ["192.168.1.3", "192.168.1.4"]
 * [false,false,true]
 *
 */
public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param ipArr string字符串一维数组 待校验 IP 列表
     * @param blackIpArr string字符串一维数组 IP 黑名单列表
     * @return bool布尔型一维数组
     */
    public static boolean[] isBlackIp (String[] ipArr, String[] blackIpArr) {
        // write code here
        List<String> list = Arrays.asList(blackIpArr);
        List<Boolean> ans = new ArrayList<>();
//        for (int i = 0; i < ipArr.length; i++) {
//            for (int j = 0; j < blackIpArr.length; j++) {
//                list.add(ipArr[i].equals(blackIpArr[j]));
//            }
//        }
//        for (int i = 0; i < ipArr.length; i++) {
//            if(list.contains(ipArr[i])) {
//                ans.add(true);
//            } else {
//                ans.add(false);
//            }
//        }
        //Boolean[] res = list.toArray(new Boolean[list.size()]);

        for (int i = 0; i < ipArr.length; i++) {
            int tp = Arrays.binarySearch(blackIpArr, ipArr[i]);
            if(tp > 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        boolean[] res = new boolean[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] ipArr = {"192.168.1.1", "192.168.1.2", "192.168.1.3"};
        String[] blackIpArr = {"192.168.1.3", "192.168.1.4"};
        System.out.println(Arrays.toString(isBlackIp(ipArr, blackIpArr)));
    }
}
