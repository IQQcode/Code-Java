package jvmstack;

import java.util.Date;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-25 09:39
 * @Description:局部变量表容量测试
 */
public class LocalVariablesTest01 {
    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest01 test = new LocalVariablesTest01();
        int num = 10;
        test.test1();
    }

    //练习：
    public static void testStatic(){
        LocalVariablesTest01 test = new LocalVariablesTest01();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
        //因为this变量不存在于当前方法的局部变量表中！！
        //System.out.println(this.count);
    }

    //关于Slot的使用的理解
    public LocalVariablesTest01(){
        this.count = 1;
    }

    public void test1() {
        Date date = new Date();
        String name1 = "iqqcode";
        test2(date, name1);
        System.out.println(date + name1);
    }

    public String test2(Date dateP, String name2) {
        dateP = null;
        name2 = "Mr.Q";
        double weight = 130.5;//占据两个slot
        char gender = '男';
        return dateP + name2;
    }

    public void test3() {
        this.count++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c使用之前已经销毁的变量b占据的slot的位置
        int c = a + 1;
    }

    public void test5Temp() {
        int num;
        //System.out.println(num);//错误信息：变量num未进行初始化
    }
}
