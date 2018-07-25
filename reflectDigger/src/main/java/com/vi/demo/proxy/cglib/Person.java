package com.vi.demo.proxy.cglib;

public class Person{

    private String name;

    private int age;

    public Person(){
    }

    public Person(String name_,int age_){
        this.name = name_;
        this.age = age_;
    }

    public void sayHello() {
        System.out.println("hello,I am a person,my name is:"+name+" age:"+age);
    }
}
