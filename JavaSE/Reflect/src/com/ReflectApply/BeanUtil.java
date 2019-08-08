package com.ReflectApply;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtil {
    public BeanUtil() { }

    /**
     *
     * @param actionObj 拿到提供给用户使用的xxAction(它包含了用户具体使用的子类) EmpAction一定包含了Emp()
     * @param beanValue 要设置的具体值
     *   emp.name:Mr.Q|emp.jod:Coder
     */
    public static void setBeanValue(Object actionObj,String beanValue) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //字符串拆分
        String[] temp = beanValue.split("\\|");
        for(int i = 0; i < temp.length; i++) {
            //emp.jod:Coder
            String[] result = temp[i].split(":");
            /**
             * emp.jod
             * Coder
             */

            // Coder
            String realValue = result[1];
            //emp.jod
            String className = result[0].split("\\.")[0]; //emp
            String attrName = result[0].split("\\.")[1];  //job

            Object realObj = getRealObject(actionObj,className);

            //调用真正类的setter()设置属性值
            Class<?> cls = realObj.getClass();
            //拼装setter()名
            String setName = "set" + initCap(attrName);
            //取得setter()方法的method对象
            Method setMethod = cls.getMethod(setName,String.class);
            //调用invoke通过反射设置值
            setMethod.invoke(realObj,realValue);
        }
    }


    /**
     * 根据xxAction类取得真正操作的Emp类
     * 通过反射调用getEmp()
     * @param actionObj xxAction
     * @param className 要操作的类名称
     * @return
     */
    private static Object getRealObject(Object actionObj,String className) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.取得 xxAction Class对象
        Class<?> cls = actionObj.getClass();
        //2.拼装 getXX()方法名称
        String methodName = "get" + initCap(className);
        //3.取得该方法的名称
        Method getMethod = cls.getMethod(methodName);
        //4.通过反射调用该方法
        //等同于empAction.getEmp();
        return getMethod.invoke(actionObj);
    }

/*

    private static Object setRealObject(Object realObj,String realValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //调用真正类的setter()设置属性值
        Class<?> cls = realObj.getClass();
        //拼装setter()名
        String setName = "set" + initCap(realValue);
        //取得setter()方法的method对象
        Method setMethod = cls.getMethod(setName,String.class);
        //调用invoke通过反射设置值
        return setMethod.invoke(realObj,realValue);
    }
*/

    //首字母大写----> getName()
    private static String initCap(String str) {
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
