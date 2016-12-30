package com.aohuan.dodo.viewdemo.temp.pagerhelper;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by dodo_lihao on 2016/12/30.
 * qq: 2390183798
 */
public class NoScrollViewPager2 extends ViewPager {
    public NoScrollViewPager2(Context context) {
        super(context);
    }

    public NoScrollViewPager2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public void scrollTo(int x, int y) {
//        super.scrollTo(x, y);
//    }
//
//    @Override
//    public void setCurrentItem(int item, boolean smoothScroll) {
//        super.setCurrentItem(item, smoothScroll);
//    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
        super.setCurrentItem(item, false);
    }
}
