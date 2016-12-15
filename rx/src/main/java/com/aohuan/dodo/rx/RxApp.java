package com.aohuan.dodo.rx;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by dodo_lihao on 2016/12/9.
 * qq: 2390183798
 */
public class RxApp extends Application {

    private static RxApp appInstance ;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        Stetho.initializeWithDefaults(this);
    }

    public static RxApp getInstance(){
        return appInstance;
    }
}
