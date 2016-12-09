package com.aohuan.dodo.javacode.rx.demo.bean;

/**
 * Created by dodo_lihao on 2016/12/8.
 * qq: 2390183798
 */
public class Person {
    String name = "";
    int age = 0;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
