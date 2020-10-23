package didipractice;

/**
 * @Author: iqqcode
 * @Date: 2020-10-21 14:20
 * @Description:
 */

import java.util.*;

public class Main {


    public static void main(String[] args) {
        int[] arr_five = new int[10];
        for (int i = 0; i < arr_five.length; i++) {
            arr_five[i] = randFive();
        }

        System.out.println("生成1-5的随机数: " + Arrays.toString(arr_five));


        int[] arr_seven = new int[10];
        for (int i = 0; i < arr_seven.length; i++) {
            arr_seven[i] = getRandomNumSevenI();
        }

        // 测试统计
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("<<测试方法二>>");
        for (int i = 0; i < 1000000; i++) {

            // 测试方法二
            int temp = getRandomNumSevenII();

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

    /**
     * Random类产生随机数
     * @param
     */
    public static int randFive() {
        Random random = new Random();
        int rand_five = random.nextInt(5) + 1;
        return rand_five;
    }

    /**
     * Math.random()产生随机数
     * @param
     */
    public static int randFiveII(int[] arr) {
        int max = 5, min = 1;
        int rand_five = (int) (Math.random() * 5 + 1);
        return rand_five;
    }

    public static int randFiveIII() {
        int max = 100, min = 1;
        long randomNum = System.currentTimeMillis();
        int rand_five = (int) (randomNum % (max - min) + min);
        //循环同一时间会产生相同的数
       return rand_five;
    }


    /**
     * 调用randFive()来 等概率 产生 1-7
     * @return
     */
    public static int getRandomNumSevenI() {
        while (true) {
            int randLowSeven = (randFive() - 1) * 5 + randFive();
            if(randLowSeven <= 21) {
                return randLowSeven % 7 + 1;
            }
        }
    }



    public static int getRandomNumSevenII() {
        int randLowSeven = 0;
        while ((randLowSeven = randFive() * 5 + randFive()) > 26);

        return (randLowSeven - 3) / 3;
    }




}
