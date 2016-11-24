package com.aohuan.dodo.javacode.jsoup.sample1.detail;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by dodo_lihao on 2016/11/24.
 * qq: 2390183798
 */
public class DoSth1 {

    static String url = "http://www.jianshu.com/";

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

//        test1Body();
//        test2ConnectBody();
        test3Article();

    }


    public static void test1Body() throws IOException {
        // 直接从字符串中输入 HTML 文档
        String html = "<html><head><title> 这里是title </title></head>"
                + "<body><p> 这里是 jsoup 项目的body的p </p></body></html>";
//        Document doc = Jsoup.parse(html, "UTF-8");//UTF-8       ISO-8859-1        US-ASCII     gbk
        Document doc = Jsoup.parse(html);
        System.out.println(doc.body());
    }

    /**
     * 获取指定HTML 的body
     *
     * @throws IOException
     */
    public static void test2ConnectBody() throws IOException {
        Document doc2 = Jsoup.connect(url).get();
        String content = doc2.toString();
//        String content = doc2.body().toString();
        System.out.println(content);
    }

    /**
     * 获取博客上的文章标题和链接
     */
    public static void test3Article() {
//        printElement(getArticleElements());
        printAtoHrefAndText(getTitles(getClassTitleElements()));
//        printElement(getClassTitleElements());
    }

    public static Elements getArticleElements() {
        Elements elementsAll = new Elements();
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements ListDiv = doc.getElementsByAttributeValue("class", "article-list thumbnails");
            for (Element element : ListDiv) {
                Elements links = element.getElementsByTag("a");
                for (Element link : links) {
                    elementsAll.add(link);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return elementsAll;
    }

    public static Elements getClassTitleElements() {
        Elements elementsAll = new Elements();
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements ListDiv = doc.getElementsByAttributeValue("class", "article-list thumbnails");
            for (Element element : ListDiv) {
                Elements links = element.getElementsByAttributeValue("class", "title");
                elementsAll.addAll(links);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return elementsAll;
    }


    public static Elements getTitles(Elements elements) {
        Elements elementsAll = new Elements();
        for (Element ele : elements) {
            Elements links = ele.getElementsByTag("a");
            elementsAll.addAll(links);
        }
        return elementsAll;
    }


    static int num = 0;
    public static void printAtoHrefAndText(Elements elements) {
        for (Element link : elements) {
            num++;
            String linkHref = link.attr("href");
            String linkText = link.text().trim();
            System.out.println("linkHref "+ num +" : \t\t" + linkHref);
            System.out.println("linkText "+ num +" : \t\t" + linkText);
        }
    }

    public static void printElement(Elements elements){
        for (Element link : elements) {
            org.jsoup.nodes.Attributes att = link.attributes();
            for (org.jsoup.nodes.Attribute item : att){
                System.out.println(item);
            }
        }
    }

}
