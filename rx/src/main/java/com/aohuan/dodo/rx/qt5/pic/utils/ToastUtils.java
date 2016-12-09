package com.aohuan.dodo.rx.qt5.pic.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by C.C on 2016/7/26.
 */

public class ToastUtils {
    private static Toast toast;

    public static void show(Context context, String info) {
        if (toast == null) {
            toast = Toast.makeText(context, info, Toast.LENGTH_SHORT);
        } else {
            toast.setText(info);
        }
        toast.show();
    }
}
