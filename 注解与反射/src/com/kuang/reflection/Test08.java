package com.kuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.kuang.reflection.User");
        // User user = new User();
        // c1 = user.getClass();
        //获得类的名字
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        //获得类的属性
        //Field[] fields = c1.getFields();只能找到public属性
        Field[] fields = c1.getDeclaredFields();//可以找到所有属性
        for (Field field : fields) {
            System.out.println(field);
        }
         Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("======================");
        //获得类的方法
        Method[] methods = c1.getMethods();//获得本类及其父类的public方法
//        for (Method method : methods) {
//            System.out.println(method);
//        }
        methods = c1.getDeclaredMethods();//获得本类的所有方法（公有和私有方法都可以）
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取指定的方法
        //重载
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);
        System.out.println("======================");
        //获得指定的构造器
        System.out.println("获得指定的构造器");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("=====================");
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //获得指定的构造器（无参构造、有参构造）
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(declaredConstructor);
    }
}
