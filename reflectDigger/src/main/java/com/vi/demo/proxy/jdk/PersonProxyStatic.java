package com.vi.demo.proxy.jdk;

public class PersonProxyStatic implements PersonInf {

    private PersonInf person;

    public PersonProxyStatic(PersonInf person_) {
        this.person = person_;
    }

    public void sayHello() {
        System.out.println("begin");
        person.sayHello();
        System.out.println("end");
    }

    public static void main(String[] args) {
        PersonInf person = new Person("chen", 123);
        new PersonProxyStatic(person).sayHello();
    }

}
