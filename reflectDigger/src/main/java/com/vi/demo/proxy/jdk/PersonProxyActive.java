package com.vi.demo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonProxyActive implements InvocationHandler {

    private PersonInf person;

    public PersonProxyActive(PersonInf person_) {
        this.person = person_;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("-----before-----");
        Object result = method.invoke(person, args);
        System.out.println("-----end-----");
        return result;
    }

    // 生成代理对象
    public Object getProxy() {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //ClassLoader loader = this.getClass().getClassLoader();这种方式获取类加载器也可以
        Class<?>[] interfaces = person.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader, interfaces, this);
    }

    public static void main(String[] args) {

        PersonInf person = (PersonInf) new Person("chen",123);
        PersonProxyActive handler = new PersonProxyActive(person);
        PersonInf personInf = (PersonInf)handler.getProxy();
        personInf.sayHello();
    }
}
