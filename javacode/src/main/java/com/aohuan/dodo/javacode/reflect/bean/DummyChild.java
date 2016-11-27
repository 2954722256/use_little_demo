package com.aohuan.dodo.javacode.reflect.bean;

/**
 * Created by dodo_lihao on 2016/11/27.
 * qq: 2390183798
 */
public class DummyChild extends DummyFather{

    public String name;
    private int age;

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

    private String dodo(String str){
        System.out.println("you can't get here. dodo " + str);
        return "dodo" + str;
    }

    private static String dodoDo(int num){
        System.out.println("you can't get here. dodoDo " + num);
        return "dodoDo " + num;
    }

}
