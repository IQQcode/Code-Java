package iqqcode.single.reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-14 22:45
 * @Description:解决双反射爆破DCL
 */
class SafeSingleton03 {

    //使用volatile关键字保其可见性
    private volatile static SafeSingleton03 single = null;
    //添加标志位
    private static boolean flag = false;

    private SafeSingleton03() {
        synchronized (SafeSingleton03.class) {
            if (flag == false) {
                flag = true;
            }else {
                throw new RuntimeException("Don't destroy by reflection");
            }
        }
    }

    //同步代码块上锁
    public static SafeSingleton03 getInstance() {
        if(single == null) {
            synchronized (SafeSingleton03.class) {
                //双重检查
                if (single == null) {
                    single = new SafeSingleton03();
                }
            }
        }
        return single;
    }

    public static void main(String[] args) throws Exception {
        Constructor<SafeSingleton03> dc = SafeSingleton03.class.getDeclaredConstructor();
        dc.setAccessible(true);
        SafeSingleton03 single = dc.newInstance();

        //再次通过反射修改属性值
        Field flag = SafeSingleton03.class.getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(dc,false);

        SafeSingleton03 singleCopy = dc.newInstance();

        System.out.println(single);
        System.out.println(singleCopy);
        System.out.println(single == singleCopy);
    }
}

