package com.ReflectApply;

import java.lang.reflect.InvocationTargetException;

/**
 * 方便用户使用而抽象出的类，不用多次setter()设置值
 * emp.name:Mr.Q|emp.jod:Coder
 */

public class EmpAction {
    //最终提供给用户用的类
    private Emp emp = new Emp();
    public void setEmpValue(String str) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //this表示当前对象，哪个对象调用的 setBeanValue
        BeanUtil.setBeanValue(this,str);
    }
    public Emp getEmp() {
        return this.emp;  //设置属性的类返回给用户
    }
}
