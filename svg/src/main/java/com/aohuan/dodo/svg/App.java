package com.aohuan.dodo.svg;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by dodo_lihao on 2016/11/18.
 * qq: 2390183798
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
