package com.aohuan.dodo.javacode.reflect.sample2;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by dodo_lihao on 2016/12/2.
 * qq: 2390183798
 */
public class DoAnnotation2 {

    public static void main(String[] args){
        File file = new File("SqlCreateTable/src/com/company/bean");
        if (!file.exists())
            return ;
//        File[] files = file.listFiles((s) -> {
//            return s.getName().endsWith(".java");
//        });

        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return false;
            }
        });
    }


}
