package iqqocde.gcroots;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-05 11:14
 * @Description:GCRoots查看
 */
public class GCRootsTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Date birth = new Date();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("数据添加完毕,请操作: ");
        new Scanner(System.in).next();

        list = null;
        birth = null;

        System.out.println("list, date已置空,请操作: ");
        new Scanner(System.in).next();
        System.out.println("结束");
    }
}
