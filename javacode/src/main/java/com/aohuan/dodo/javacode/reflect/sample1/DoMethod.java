package com.aohuan.dodo.javacode.reflect.sample1;

import com.aohuan.dodo.javacode.reflect.bean.DummyChild;
import com.aohuan.dodo.javacode.reflect.bean.DummyFather;
import com.aohuan.dodo.javacode.reflect.utils.DUtils;

import java.lang.reflect.Method;

/**
 * Created by dodo_lihao on 2016/11/27.
 * qq: 2390183798
 */
public class DoMethod {

    public static void main(String[] args) throws NoSuchFieldException {
        DoMethod doMethod = new DoMethod();
//        doMethod.getFatherMethods();
//        doMethod.getFatherDeclaredMethods();


//        doMethod.getChildMethods();
        doMethod.getChildDeclaredMethods();
    }


    /**
     * 打印一下 DummyFather 的 getMethods方法
     */
    private void getFatherMethods(){
        Method[] m1s = DummyFather.class.getMethods();
        DUtils.println("method length: " + m1s.length + "");

        for(int i=0; i<m1s.length; i++){
            DUtils.println("");
            DUtils.println(m1s[i].getGenericReturnType() + "");
            DUtils.println(m1s[i].getName());
            DUtils.println(m1s[i].getModifiers() +"");
        }
    }


    /**
     * 打印一下 DummyFather 的 getDeclaredMethods 方法
     */
    private void getFatherDeclaredMethods(){
        Method[] m1s = DummyFather.class.getDeclaredMethods();
        DUtils.println("method length: " + m1s.length + "");

        for(int i=0; i<m1s.length; i++){
            DUtils.println("");
            DUtils.println(m1s[i].getGenericReturnType() + "");
            DUtils.println(m1s[i].getName());
            DUtils.println(m1s[i].getModifiers() +"");
        }
    }


    /**
     * 打印一下 DummyChild 的 getMethods方法
     */
    private void getChildMethods(){
        Method[] m1s = DummyChild.class.getMethods();
        DUtils.println("method length: " + m1s.length + "");

        for(int i=0; i<m1s.length; i++){
            DUtils.println("");
            DUtils.println(m1s[i].getGenericReturnType() + "");
            DUtils.println(m1s[i].getName());
            DUtils.println(m1s[i].getModifiers() +"");
        }
    }


    /**
     * 打印一下 DummyChild 的 getDeclaredMethods
     */
    private void getChildDeclaredMethods(){
        Method[] m1s = DummyChild.class.getDeclaredMethods();
        DUtils.println("method length: " + m1s.length + "");

        for(int i=0; i<m1s.length; i++){
            DUtils.println("");
            DUtils.println(m1s[i].getGenericReturnType() + "");
            DUtils.println(m1s[i].getName());
            DUtils.println(m1s[i].getModifiers() +"");
        }
    }


    private void getDe


}
