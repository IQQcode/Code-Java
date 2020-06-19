package iqqcode.single.reflect;

import java.lang.reflect.Constructor;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-14 20:19
 * @Description:反射爆破DCL---单例01
 */
class SafeSingleton {

    //使用volatile关键字保其可见性
    private volatile static SafeSingleton single = null;

    private SafeSingleton() {
        synchronized (SafeSingleton.class) {
            if (single != null) {
                throw new RuntimeException("Don't destroy by reflection");
            }
        }
    }

    //同步代码块上锁
    public static SafeSingleton getInstance() {
        if(single == null) {
            synchronized (SafeSingleton.class) {
                //双重检查
                if (single == null) {
                    single = new SafeSingleton();
                }
            }
        }
        return single;
    }
}

public class ReflectDCL01 {
    public static void main(String[] args) throws Exception {
        SafeSingleton single = SafeSingleton.getInstance();
        Constructor<SafeSingleton> dc = SafeSingleton.class.getDeclaredConstructor();
        dc.setAccessible(true);
        SafeSingleton singleCopy = dc.newInstance();
        //false,单例被破坏
        System.out.println(singleCopy == single);
    }
}

