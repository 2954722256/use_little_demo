package com.aohuan.dodo.javacode.reflect.sample1;

import com.aohuan.dodo.javacode.reflect.bean.DummyChild;
import com.aohuan.dodo.javacode.reflect.utils.DUtils;

import java.lang.reflect.Field;

/**
 * Created by dodo_lihao on 2016/11/27.
 * qq: 2390183798
 */
public class DoField {

    public static void main(String[] args) throws NoSuchFieldException {
        DoField doField = new DoField();
//        doField.getChildField1Name();
//        doField.getChildField2AgeDeclaredField();
//        doField.getChildField2AgeFieldE();

//        doField.getChildFields();
        doField.getChildDeclaredFields();

    }

    /**
     * 调用 本类public的Field， getDeclaredField 和 getField 都满足
     * @throws NoSuchFieldException
     */
    private void getChildField1Name() throws NoSuchFieldException {
        Field f = DummyChild.class.getDeclaredField("name");
        Field f2 = DummyChild.class.getField("name");
        DUtils.println(f.getName());
        DUtils.println(f2.getName());
    }


    /**
     *  调用 本类 private 的Field， getDeclaredField 满足
     * @throws NoSuchFieldException
     */
    private void getChildField2AgeDeclaredField() throws NoSuchFieldException {
        Field f = DummyChild.class.getDeclaredField("age");
        DUtils.println(f.getName());
    }

    /**
     *  调用 本类 private 的Field， getField 不满足
     * @throws NoSuchFieldException
     */
    private void getChildField2AgeFieldE() throws NoSuchFieldException {
        Field f2 = DummyChild.class.getField("age");
        DUtils.println(f2.getName());
    }

    /**
     * getFields 可以得到包括父类，所有的public方法
     */
    private void getChildFields(){
        Class<?> c1 = DummyChild.class;
        Field[] fields = c1.getFields();
        for(int i=0; i<fields.length; i++){
            System.out.println();
            System.out.println(fields[i].getType());
            System.out.println(fields[i].getName());
            System.out.println(fields[i].getModifiers());
        }
    }


    /**
     * getFields 可以得到包括父类，所有的public方法
     */
    private void getChildDeclaredFields(){
        Class<?> c1 = DummyChild.class;
        Field[] fields = c1.getDeclaredFields();
        for(int i=0; i<fields.length; i++){
            System.out.println();
            System.out.println(fields[i].getType());
            System.out.println(fields[i].getName());
            System.out.println(fields[i].getModifiers());
        }
    }



}
