package com.aohuan.dodo.javacode.reflect.sample1;

import com.aohuan.dodo.javacode.reflect.utils.DUtils;
import com.aohuan.dodo.javacode.reflect.utils.DummyClass;

/**
 * Created by dodo_lihao on 2016/11/27.
 * qq: 2390183798
 */
public class DoClass {

    public static void main(String[] args){
        DoClass doClass = new DoClass();
//        doClass.doClass1();
//        doClass.doClass2();
//        doClass.doClass3();

//        doClass.doClassName1();
//        doClass.doClassName2();
//        doClass.doClassSimpleName3();

        doClass.doNewInstance1();
    }

    private void doClass1() {
        Class<?> c1 = new DummyClass().getClass();
        DUtils.println(c1.toString());
    }

    private void doClass2(){
        Class<?> c2 = DummyClass.class;
        DUtils.println(c2.toString());
    }

    private void doClass3(){
        try {
            Class<?> c3 = Class.forName("com.aohuan.dodo.javacode.reflect.utils.DummyClass");
            DUtils.println(c3.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void doClassName1(){
        Class<?> c1 = new DummyClass().getClass();
        DUtils.println(c1.getName());
    }

    private void doClassName2(){
        Class<?> c2 = DummyClass.class;
        DUtils.println(c2.getName());
    }

    private void doClassSimpleName3(){
        try {
            Class<?> c3 = Class.forName("com.aohuan.dodo.javacode.reflect.utils.DummyClass");
            DUtils.println(c3.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void doNewInstance1(){
        try {
            DummyClass bean11 = new DummyClass().getClass().newInstance();
            System.out.println(bean11.toString());
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }





}
