package com.aohuan.dodo.javacode.jsoup.sample1.detail;

import com.aohuan.dodo.javacode.jsoup.sample1.utils.GetDataUtils;
import com.aohuan.dodo.javacode.jsoup.sample1.utils.JianShuUtils;
import com.aohuan.dodo.javacode.jsoup.sample1.utils.PrintCollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dodo_lihao on 2016/11/25.
 * qq: 2390183798
 * <p/>
 * 前面可以通过设置属性
 * 但是，不能翻页
 * 简书是自动翻页的，我们要拿到对应url，再次爬取，添加上去
 * （问题，万一中间有一条断掉了，就会错误，后面的逻辑就不通了）
 * （简书没有对ip 和 拉取速度做限制）
 * <p/>
 * 这边简单跟了下
 * http://www.jianshu.com/users/edadc0d25b46/followers?_=1480068458989&amp;page=5
 *
 *
 *
 */
public class DoSth3 {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//        doGetFollowerPageData(2);
//        doGetFollowerPageData(11);
//        doGetFollowerPageData(12);

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

    private static void doGetFollowerPageData(int pageNum) throws IOException {
        PrintCollectionUtils.printMap(
                GetDataUtils.getSpicalProperty(
                        JianShuUtils.getPagerAppend(
                                JianShuUtils.getFollowerUrl(JianShuUtils.KEY_DODO_ID),
                                pageNum),
                        "h4 a")
        );
    }





}
