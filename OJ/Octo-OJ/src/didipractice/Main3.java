package didipractice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: iqqcode
 * @Date: 2020-10-22 07:23
 * @Description:
 */
public class Main3 {
    public static int rand1ToM(int m) {
        return (int) (Math.random() * m) + 1;
    }

    //产生1-n的随机函数
    public static int rand1ToN(int n, int m) {
        int[] nMSys = getMSysNum(n - 1, m);
        int[] randNum = getRanMSysNumLessN(nMSys, m);
        return getNumFromMSysNum(randNum, m) + 1;
    }

    // 把value转成m进制的数
    public static int[] getMSysNum(int value, int m) {
        int[] res = new int[32];
        int index = res.length - 1;
        while (value != 0) {
            res[index--] = value % m;
            value = value / m;
        }
        return res;
    }

    // 等概率随机产生一个0~nMsys范围上的数，只不过是m进制表达的。
    public static int[] getRanMSysNumLessN(int[] nMSys, int m) {
        int[] res = new int[nMSys.length];
        int start = 0;
        while (nMSys[start] == 0) {
            start++;
        }
        int index = start;
        boolean lastEqual = true;
        while (index != nMSys.length) {
            res[index] = rand1ToM(m) - 1;
            if (lastEqual) {
                if (res[index] > nMSys[index]) {
                    index = start;
                    lastEqual = true;
                    continue;
                } else {
                    lastEqual = res[index] == nMSys[index];
                }
            }
            index++;
        }
        return res;
    }

    // 把m进制的数转成10进制
    public static int getNumFromMSysNum(int[] mSysNum, int m) {
        int res = 0;
        for (int i = 0; i != mSysNum.length; i++) {
            res = res * m + mSysNum[i];
        }
        return res;
    }


    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("randM 等概率产生 [1 - n]的随机数: ");
        for (int i = 0; i < 1000000; i++) {

            // 测试方法二
            int temp = rand1ToN(4, 5);

            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        map.forEach((key, value) -> {
            System.out.println(key + " -- 出现次数:" + value);
        });
    }
}
