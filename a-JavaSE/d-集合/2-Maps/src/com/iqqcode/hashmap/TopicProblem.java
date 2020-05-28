package com.iqqcode.hashmap;

import java.util.HashMap;
import java.util.Map;
import	java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 11:33
 * @Description:计算一个字符串中每个字符出现次数
 * @Solution:
 * 1.使用 Scanner获取用户输入的字符串
 * 2.创建Map集合，key是字符串中的字符， value是字符的个数
 * 3.遍历字符串获取每一个字符
 * 4.使用获取到的字符，去Map集合判断key是否存在
 *        key存在：
 *                通过字符（key），获取vaue（字符个数）
 *                value++
 *                put（key, value）把新的 value存储到Map集合中
 *        key不存在：
 *                put（key, 1）
 * 5.遍历Map集合，输出結果
 */
public class TopicProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入一个字符串：");
        String str = sc.nextLine();
        //创建Mp集合，key是字符串中的字符，value是字符的个数
        HashMap<Character,Integer> map = new HashMap<> ();
        //遍历字符串，获取到每一个字符
        for (Character c : str.toCharArray()) {
            //使用获取到的字符，去Map集合判断key是否存在
            if (map.containsKey(c)) {
                //key存在
                Integer value = map.get(c);
                value++;
                map.put(c, value);
            }else {
                //key不存在
                map.put(c , 1);
            }
        }

        //遍历集合输出结果
        /*for (Character key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }*/

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
