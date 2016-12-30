package com.aohuan.dodo.viewdemo.temp.pagerhelper;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by dodo_lihao on 2016/12/29.
 * qq: 2390183798
 */
public class ChildViewPager2 extends ViewPager {

    private static final String TAG = "xujun";
    public ChildViewPager2(Context context) {
        super(context);
    }

    public ChildViewPager2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    long num = 0;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int curPosition;

        Log.i(TAG, "curPosition:=" + num++);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                curPosition = this.getCurrentItem();
                int count = this.getAdapter().getCount();
                Log.i(TAG, "curPosition:=" + curPosition);
                // 当当前页面在最后一页和第0页的时候，由父亲拦截触摸事件
                if (curPosition == count - 1|| curPosition==0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {//其他情况，由孩子拦截触摸事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                }

        }
        return super.dispatchTouchEvent(ev);
    }
}
