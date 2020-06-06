package com.iqqcode.table;
import java.util.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-01 08:05
 * @Description:存储表格
 * | ID   | 姓名  | 年龄  | 毕业日期 |
 * | ---- | --- | --- | ------- |
 * | 1001 | 张三  | 18  | 2020-09 |
 * | 1002 | 李四  | 20  | 2021-07 |
 * | 1003 | 王五  | 22  | 2017-07 |
 *
 * - 每一行使用一个Map
 * - 整个表格使用List
 */
public class ListMapTable {
    public static void main(String[] args) {
        Map<String,Object> map1 = new HashMap<>();
        map1.put("ID",1001);
        map1.put("姓名","张三");
        map1.put("年龄",18);
        map1.put("毕业日期","2020-09");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("ID",1002);
        map2.put("姓名","李四");
        map2.put("年龄",20);
        map2.put("毕业日期","2021-07");

        Map<String,Object> map3 = new HashMap<>();
        map3.put("ID",1003);
        map3.put("姓名","王五");
        map3.put("年龄",22);
        map3.put("毕业日期","2017-07");

        List<Map<String,Object>> table = new ArrayList<> ();
        table.add(map1);
        table.add(map2);
        table.add(map3);

        for (Map<String, Object> row : table) {
            //将每行的内容放入到Set中
            Set <String> keyset= row.keySet();
            for (String key : keyset) {
                System.out.print(key+": " + row.get(key) + "\t");
            }
            System.out.println();
        }
    }
}
