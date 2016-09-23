package com.aohuan.demo.annotation_test;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aohuan.demo.annotation_test.helper.InjectHelper1;
import com.aohuan.demo.annotation_test.helper2.InjectHelper;

/**
 * Created by Administrator on 2016/9/23.
 */
public class BaseActivity1 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle arg0) {
            super.onCreate(arg0);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            try {
                setContentView(InjectHelper1.injectObject(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
