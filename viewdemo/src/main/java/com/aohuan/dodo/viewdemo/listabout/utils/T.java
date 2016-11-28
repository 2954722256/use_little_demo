package com.aohuan.dodo.viewdemo.listabout.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aohuan.dodo.viewdemo.R;

/**
 * Created by dodo_lihao on 2016/11/28.
 * qq: 2390183798
 */
public class T {
    /** 上次的时间 */
    private static long lastTime;
    private static View layout;

    public static void toast(Context context, String toast) {
        if (System.currentTimeMillis() - lastTime > 2000) {
//            Toast.makeText(context,toast,Toast.LENGTH_SHORT).show();
            lastTime = System.currentTimeMillis();
            layout = LayoutInflater.from(context).inflate(R.layout.utils_toastal, null);
//            ViewGroup mGroup = (ViewGroup)layout.findViewById(R.id.parent_pane2);

            TextView text = (TextView) layout.findViewById(R.id.toast_text);
            text.setText(toast);
            android.widget.Toast toast1 = new android.widget.Toast(context);
            toast1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 100);
            toast1.setDuration(android.widget.Toast.LENGTH_SHORT);
            toast1.setView(layout);
            toast1.show();
        }
    }


    /** 判断输入框是否为空 */
    public static boolean isNull(Context context,String textContent,String toastContent){
        if(textContent.isEmpty()){
            toast(context,toastContent);
        }
        return textContent.isEmpty();
    }
}
