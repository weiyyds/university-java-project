package com.kuang.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获得类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取系统加载类的父类加载器=》扩展加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //获取扩展加载器的父类=》引导类加载器（c/c++写的）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        //测试当前类是哪个加载器加载
        ClassLoader classLoader = Class.forName("com.kuang.reflection.Test07").getClassLoader();
        System.out.println(classLoader);
        //测试jdk内置的类是谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
/**
 * D:\environment\jdk\jre\lib\charsets.jar;
 * D:\environment\jdk\jre\lib\deploy.jar;
 * D:\environment\jdk\jre\lib\ext\access-bridge-64.jar;
 * D:\environment\jdk\jre\lib\ext\cldrdata.jar;
 * :\environment\jdk\jre\lib\ext\dnsns.jar;
 * D:\environment\jdk\jre\lib\ext\jaccess.jar;
 * D:\environment\jdk\jre\lib\ext\jfxrt.jar;
 * D:\environment\jdk\jre\lib\ext\localedata.jar;
 * D:\environment\jdk\jre\lib\ext\nashorn.jar;
 * D:\environment\jdk\jre\lib\ext\sunec.jar;
 * D:\environment\jdk\jre\lib\ext\sunjce_provider.jar;
 * D:\environment\jdk\jre\lib\ext\sunmscapi.jar;
 * D:\environment\jdk\jre\lib\ext\sunpkcs11.jar;
 * D:\environment\jdk\jre\lib\ext\zipfs.jar;
 * D:\environment\jdk\jre\lib\javaws.jar;
 * D:\environment\jdk\jre\lib\jce.jar;
 * D:\environment\jdk\jre\lib\jfr.jar;
 * D:\environment\jdk\jre\lib\jfxswt.jar;
 * D:\environment\jdk\jre\lib\jsse.jar;
 * D:\environment\jdk\jre\lib\management-agent.jar;
 * D:\environment\jdk\jre\lib\plugin.jar;
 * D:\environment\jdk\jre\lib\resources.jar;
 * D:\environment\jdk\jre\lib\rt.jar;
 * F:\ideaworkspace\注解与反射\out\production\注解与反射;
 * F:\idea2020\IntelliJ IDEA 2020.1\lib\idea_rt.jar
 */
    }
}
