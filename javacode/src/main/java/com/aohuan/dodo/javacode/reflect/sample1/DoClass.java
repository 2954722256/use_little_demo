package com.aohuan.dodo.javacode.reflect.sample1;

import com.aohuan.dodo.javacode.reflect.utils.DUtils;
import com.aohuan.dodo.javacode.reflect.bean.DummyClass;

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

    /**
     * 第1种方式，得到Class对象
     */
    private void doClass1() {
        Class<?> c1 = new DummyClass().getClass();
        DUtils.println(c1.toString());
    }

    /**
     * 第2种方式，得到Class对象
     */
    private void doClass2(){
        Class<?> c2 = DummyClass.class;
        DUtils.println(c2.toString());
    }

    /**
     * 第3种方式，得到Class对象
     */
    private void doClass3(){
        try {
            Class<?> c3 = Class.forName("com.aohuan.dodo.javacode.reflect.bean.DummyClass");
            DUtils.println(c3.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第1种方式，得到Class对象
     * class对象获得Class的Name
     */
    private void doClassName1(){
        Class<?> c1 = new DummyClass().getClass();
        DUtils.println(c1.getName());
    }

    /**
     * 第2种方式，得到Class对象
     * class对象获得Class的Name
     */
    private void doClassName2(){
        Class<?> c2 = DummyClass.class;
        DUtils.println(c2.getName());
    }

    /**
     * 第3种方式，得到Class对象
     * class对象获得Class的SimpleName
     */
    private void doClassSimpleName3(){
        try {
            Class<?> c3 = Class.forName("com.aohuan.dodo.javacode.reflect.bean.DummyClass");
            DUtils.println(c3.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第3种方式，得到Class对象
     * class对象的newInstance，来实例化对象
     */
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
