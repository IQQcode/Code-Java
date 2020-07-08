package iqqocde.loader;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-23 17:03
 * @Description:查看类加载器层级关系
 */
public class ClassLoaderView01 {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); //sun.misc.Launcher$AppClassLoader@b4aac2

        //获取其上层: 拓展类加载器
        ClassLoader extenClassLoader = systemClassLoader.getParent();
        System.out.println(extenClassLoader); //sun.misc.Launcher$ExtClassLoader@14ae5a5

        //获取不到其上层: 引导类加载器
        ClassLoader bootStrapLoader = extenClassLoader.getParent();
        System.out.println(bootStrapLoader); //null

        //用户自定义类加载器: 默认使用系统类加载器
        ClassLoader definedClassLoader = ClassLoaderView01.class.getClassLoader();
        System.out.println(definedClassLoader); //sun.misc.Launcher$AppClassLoader@b4aac2

        //String类使用引导类加载器进行加载: Java的核心类库都是使用引导类加载器完成加载
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader); //null
    }
}
