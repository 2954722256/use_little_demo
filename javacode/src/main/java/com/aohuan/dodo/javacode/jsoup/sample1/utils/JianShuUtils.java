package com.aohuan.dodo.javacode.jsoup.sample1.utils;

/**
 * Created by dodo_lihao on 2016/11/25.
 * qq: 2390183798
 */
public class JianShuUtils {

    public static final String KEY_DODO_ID = "edadc0d25b46";
    public static final String JIANSHU_URL = "http://www.jianshu.com";
    public static final String KEY_USERS_MID = "/users";
    public static final String KEY_FOLLOWERS_LAST = "followers";
    public static final String KEY_FOLLOWING_LAST = "following";


    //分页的地址
//    http://www.jianshu.com/users/edadc0d25b46/followers?_=1480068458989&amp;page=5



    /**
     * 通过id拿到对应的followers页面url
     * @param id
     * @return
     */
    public static String getFollowerUrl(String id) {
        return JIANSHU_URL + KEY_USERS_MID + "/" + id + "/" + KEY_FOLLOWERS_LAST;
    }

    /**
     * 通过id拿到对应的following页面url
     * @param id
     * @return
     */
    public static String getFollowingUrl(String id){
        return JIANSHU_URL + KEY_USERS_MID + "/" + id + "/" + KEY_FOLLOWING_LAST;
    }



    public static String getPagerAppend(String url, int pagerNum){
        return new StringBuffer(url).append("?").append("page=").append(pagerNum).toString();
    }


}
