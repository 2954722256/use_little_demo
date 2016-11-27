package com.aohuan.dodo.javacode.jsoup.sample1.utils;

import com.aohuan.dodo.javacode.jsoup.sample1.detail.EleType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dodo_lihao on 2016/11/25.
 * qq: 2390183798
 */
public class GetDataUtils {

    /**
     * @param url
     * @param divClass 具体的div的特征   例如：div.ClassName    ul.ClassName
     * @param testMap  对应具体item的属性map
     * @return
     * @throws IOException
     */
    public static ArrayList<HashMap<String, String>> getSpicalProperty(String url, String divClass, HashMap<EleType, String> testMap) throws IOException {
        ArrayList<HashMap<String, String>> data = new ArrayList<>();

        Document doc2 = Jsoup.connect(url).get();
        Elements eles = doc2.select(divClass);
        for (Element ele : eles) {
            HashMap<String, String> tempData = new HashMap<>();

            try {
                for (EleType et : testMap.keySet()) {
                    if (et == EleType.Attr) {
                        String attr = ele.attr(testMap.get(et));
                        tempData.put(testMap.get(et), attr);
                    } else if (et == EleType.Text) {
                        String text = ele.text().trim();
                        tempData.put(testMap.get(et), text);
                    }
                }
                data.add(tempData);
            } catch (Exception e) {
            }


        }
        return data;
    }


    /**
     * @param url      具体url
     * @param divClass 具体的div的特征   例如：div.ClassName    ul.ClassName
     * @return
     * @throws IOException
     */
    public static ArrayList<HashMap<String, String>> getSpicalProperty(String url, String divClass) throws IOException {
        HashMap<EleType, String> testMap = new HashMap<>();
        testMap.put(EleType.Attr, "href");
        testMap.put(EleType.Text, "name");

        return getSpicalProperty(url, divClass, testMap);
    }

}
