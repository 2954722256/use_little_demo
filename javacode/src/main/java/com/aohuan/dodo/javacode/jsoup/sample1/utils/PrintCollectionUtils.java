package com.aohuan.dodo.javacode.jsoup.sample1.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dodo_lihao on 2016/11/25.
 * qq: 2390183798
 */
public class PrintCollectionUtils {


    /**
     * 打印每个item的信息
     *  第一个ArrayList    是具体某个人
     *  第二个HashMap    是属性，属性值
     * @param data
     */
    public static void printMap(ArrayList<HashMap<String, String>> data) {
        if (data == null || data.size() == 0)
            return;

        for (HashMap<String, String> hm : data) {
            System.out.println("-----");
            for (String key : hm.keySet()) {
                System.out.println(key + "  :  " + hm.get(key));
            }
        }
    }

}
