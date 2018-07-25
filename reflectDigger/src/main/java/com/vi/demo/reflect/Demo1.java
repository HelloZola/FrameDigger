package com.vi.demo.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射demo
 */
public class Demo1 {

    /**
     * 实现反射构造器的获取和构造器的实现
     */
    @Test
    public void test1() {
        try {
            Class clazz = Class.forName("com.vi.demo.reflect.Person");
            Constructor[] constructors = clazz.getConstructors();//所有公有构造方法
            constructors = clazz.getDeclaredConstructors();//所有的构造方法(包括：私有、受保护、默认、公有)
            Constructor con = clazz.getConstructor(null);//获取公有、无参的构造方法
            con = clazz.getDeclaredConstructor(String.class);//获取私有构造方法，并调用

            for (Constructor constructor : constructors) {
                System.out.println(constructor.getName());
            }

            //下面我要实现一个无参的公共的构造函数
            Constructor con_demo = clazz.getConstructor(null);
            Person obj = (Person) con_demo.newInstance();//或者con_demo.newInstance(null);

            System.out.println(obj.getname());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
