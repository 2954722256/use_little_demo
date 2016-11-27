package com.aohuan.dodo.javacode.reflect.utils;

import java.lang.reflect.Constructor;

/**
 * Created by dodo_lihao on 2016/11/27.
 * qq: 2390183798
 */
public class DUtils {

    public static void println(String str){
        System.out.println(str);
    }

    public static void printConstructor(Constructor<?>[] cons){
        for(int i=0; i<cons.length; i++){
            System.out.println(cons[i]);
        }
    }

}
