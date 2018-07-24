package com.vi.demo;

public class Person {

    private String name;

    private int age;

    public Person(){
        System.out.println("进入了无参的构造器");
    }

    public Person(String name,int age){
        System.out.println("进入了带有name和age的共有构造器");
    }

    private Person(String name){
        System.out.println("进入了带有name的私有构造器");
    }

    public String getname(){

        if(name==null){
            System.out.println("name目前为空,赋予一个默认值！");
            return "demo name";
        }
        return name;
    }



}
