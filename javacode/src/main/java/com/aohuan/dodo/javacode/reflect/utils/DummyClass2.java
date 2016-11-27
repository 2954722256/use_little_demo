package com.aohuan.dodo.javacode.reflect.utils;

/**
 * Created by dodo_lihao on 2016/11/27.
 * qq: 2390183798
 */
public class DummyClass2 {

    String name;
    int age;

    public DummyClass2(String name) {
        this.name = name;
    }

    public DummyClass2(String name, int age) {
        this.age = age;
        this.name = name;
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


    public void doSomeDummyThings(){
        System.out.println("what the f.....");
    }

    @Override
    public String toString() {
        return "DummyClass{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
