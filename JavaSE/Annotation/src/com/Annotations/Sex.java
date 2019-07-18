package com.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target(用于描述修饰对象的范围)
 *   FIELD (字段声明)
 *   METHOD (方法声明)
 */

@Target(ElementType.FIELD)

/**
 * @Retention(注释类型的注释要保留多久)
 *
 * 范围取值于RetentionPolicy这个枚举类：
 *
 *    CLASS 编译器将把注释记录在类文件中,但在运行时JVM不需要保留注释
 *
 *    RUNTIME 编译器将把注释记录在类文件中,在运行时JVM将保留注释，因此可以通过反射读取
 *
 *    SOURCE 编译器要丢弃的注释
 */

@Retention(RetentionPolicy.RUNTIME)

public @interface Sex {
    enum GenderType {
        Male("男"),
        Female("女");
        private String genderSex;
        private GenderType(String gerderSex) {
            this.genderSex = genderSex;
        }
        @Override
        public String toString() {
            return genderSex;
        }
    }
    GenderType gender() default GenderType.Male;
}
