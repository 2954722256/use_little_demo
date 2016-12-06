package com.aohuan.dodo.javacode.reflect.sample2;

import com.aohuan.dodo.javacode.jsoup.sample1.utils.GetDataUtils;
import com.aohuan.dodo.javacode.jsoup.sample1.utils.JianShuUtils;
import com.aohuan.dodo.javacode.jsoup.sample1.utils.PrintCollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dodo_lihao on 2016/12/2.
 * qq: 2390183798
 *
 *
 * 这里只是前面的简单爬取的代码
 * 通过传入对应的  id， 对应的 div class等元素， 可以爬取所有 follower的简单信息
 *      （记得原来新浪第一版可以无限爬取，  新浪第二版，就有个人信息的验证，还有爬取太快会不给与响应等判断【应该是防止机器人等操作的措施】）
 *
 * 这里没有用注解
 */
public class DoAnnotation1 {

    public static void main(String[] args) throws Exception {
        doGetFollowerAllData(JianShuUtils.KEY_DODO_ID, "h4 a");
    }

    private static void doGetFollowerAllData(String id, String divClass) throws IOException {
        ArrayList<HashMap<String, String>> allData = new ArrayList<>();

        boolean isContinue = true;
        int pageNum = 1;
        while(isContinue){
            ArrayList<HashMap<String, String>> data = getFollowerPageData(id, divClass, pageNum);
            if(data == null || data.size() == 0 ){
                isContinue = false;
                pageNum --; //因为对应的没有了，数量需要减1
            }else{
                pageNum ++;
                allData.addAll(data);
//                System.out.println(data.size());
            }
        }

        System.out.println(allData.size());
        System.out.println(pageNum);
        System.out.println();
        PrintCollectionUtils.printMap(allData);
    }


    private static ArrayList<HashMap<String, String>> getFollowerPageData(String id, String divClass, int pageNum) throws IOException {
        return GetDataUtils.getSpicalProperty(
                JianShuUtils.getPagerAppend(
                        JianShuUtils.getFollowerUrl(id),
                        pageNum),
                divClass);
    }

}
