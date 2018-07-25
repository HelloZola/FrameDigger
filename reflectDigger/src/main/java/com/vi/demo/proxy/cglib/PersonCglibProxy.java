package com.vi.demo.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class PersonCglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {

        this.target = target;  //给业务对象赋值
        //创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        enhancer.setSuperclass(this.target.getClass());
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
            throws Throwable {

        System.out.println("预处理——————");
        Object result = proxy.invokeSuper(obj, args); //调用业务类（父类中）的方法
        System.out.println("调用后操作——————");
        return result;
    }

    public static void main(String[] args) {
        Person person=new Person();
        //Person person=new Person("chen",123);注意，这里的带有参数构造函数，
        //里面的参数不会起作用，代理类在构建实例时会使用无参构造器进行实例化
        PersonCglibProxy personCglibProxy=new PersonCglibProxy();
        Person bookCglib=(Person)personCglibProxy.getInstance(person);
        bookCglib.sayHello();
    }
}
