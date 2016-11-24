package com.aohuan.dodo.coordinator.utils;

import android.util.Log;

/**
 * Created by dodo_lihao on 2016/11/15.
 * qq: 2390183798
 */
public class LogE {

    private static boolean isE = true;
    private static boolean isE2 = true;

    public static void log(String str) {
        Log.e("dodoLog", str);
    }

    public static void logT(String tag, String str) {
        if (isE)
            Log.e(tag, str);
    }


    public static void log2(String str) {
        Log.e("dodoLog", str);
    }

    public static void logT2(String tag, String str) {
        if (isE2)
            Log.e(tag, str);
    }
}
