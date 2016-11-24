package com.aohuan.dodo.coordinator.dob.utils.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ScrollView;

/**
 * Created by dodo_lihao on 2016/11/14.
 * qq: 2390183798
 */
public class NestDodoSChild2 extends FrameLayout implements NestedScrollingChild {

    public NestDodoSChild2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NestDodoSChild2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }



}
