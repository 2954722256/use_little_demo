package com.aohuan.dodo.viewdemo.tab.pagerhelper;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dodo_lihao on 2016/12/29.
 * qq: 2390183798
 */
public class ParentViewPager extends ViewPager {
    public ParentViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentViewPager(Context context) {
        super(context);
    }

//    @Override
//    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
//        // return super.canScroll(v, checkV, dx, x, y);
//        return true;// /////////////////这是重点，意思就是ViewPager中的东东都可以滚动
//    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v != this && v instanceof ViewPager) {
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }
}