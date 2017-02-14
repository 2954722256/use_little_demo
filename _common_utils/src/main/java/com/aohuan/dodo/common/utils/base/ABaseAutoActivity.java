package com.aohuan.dodo.common.utils.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.aohuan.dodo.common.utils.nohttp.HttpListener;
import com.yolanda.nohttp.rest.Request;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.ButterKnife;



/**
 * Created by dodo_lihao on 2016/12/30.
 * qq: 2390183798
 */
public abstract class ABaseAutoActivity extends AppCompatActivity {


    private static Activity context;
    private static long toastNextTime;
    @Override
    protected void onCreate(Bundle arg0) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(arg0);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context = this; //??
        try {
            setContentView(InjectHelper.injectObject(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ButterKnife.inject(context);
        setStatusBarTintResource(0xff333333);
//        ZgqActivityUtils.getInstance().addActivity(this);
    }
    /**
     * 通知栏颜色
     * */
    public void setStatusBarTintResource(int colorId){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(colorId);
//            tintManager.setStatusBarTintResource(colorId);//通知栏所需颜色
        }
    }
    /** 设置状态 */
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);

    }




    // ===================   下面是AutoLayout的适配，简单写一下，以免多一层关系      ========================

    private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
    private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";
    private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";


    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        if (name.equals(LAYOUT_FRAMELAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        }

        if (name.equals(LAYOUT_LINEARLAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        }

        if (name.equals(LAYOUT_RELATIVELAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        }

        if (view != null) return view;

        return super.onCreateView(name, context, attrs);
    }



//    public <T> void request(int what, Request<T> request, HttpListener<T> callback, boolean canCancel, boolean isLoading) {
//        request.setCancelSign(this);
//        CallServer.getRequestInstance().add(this, what, request, callback, canCancel, isLoading);
//    }
//
//    @Override
//    protected void onDestroy() {
//        CallServer.getRequestInstance().cancelBySign(this);
//        super.onDestroy();
//    }

}
