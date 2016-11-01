package com.aohuan.dodo.coordinator.utils;

import android.app.Activity;
import android.view.Window;

/**
 * Created by Admin on 2016/10/31.
 */
public class Utils {

    /** 状态栏高度 */
    private static int statusBarHeight = 0;

    /** 状态栏 + Title 的高度 */
    private static int contentTop = 0;


    public static int getStatusBarHeight() {
        return statusBarHeight;
    }

    public static void setStatusBarHeight(int statusBarHeight) {
        Utils.statusBarHeight = statusBarHeight;
    }

    public static int getContentTop() {
        return contentTop;
    }

    public static void setContentTop(int contentTop) {
        Utils.contentTop = contentTop;
    }

    public static void setContentTop(Activity activity){
        Utils.contentTop = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
    }

}
