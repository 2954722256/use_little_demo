package com.aohuan.dodo.coordinator.dob.utils.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.aohuan.dodo.coordinator.utils.LogE;

/**
 * Created by dodo_lihao on 2016/11/14.
 * qq: 2390183798
 */
public class NestDodoSParent1 extends FrameLayout implements NestedScrollingParent {

    public static final String TAG = NestDodoSParent1.class.getSimpleName();


    public NestDodoSParent1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NestDodoSParent1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        LogE.logT(TAG, "onStartNestedScroll " + logNum++);
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        LogE.logT(TAG, "onNestedFling " + logNum++);
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        LogE.logT(TAG, "onNestedPreFling " + logNum++);
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public boolean onNestedPrePerformAccessibilityAction(View target, int action, Bundle args) {
        LogE.logT(TAG, "onNestedPrePerformAccessibilityAction " + logNum++);
        return super.onNestedPrePerformAccessibilityAction(target, action, args);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        LogE.logT(TAG, "onNestedPreScroll " + logNum++);
        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        LogE.logT(TAG, "onNestedScroll " + logNum++);
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        LogE.logT(TAG, "onNestedScrollAccepted " + logNum++);
        super.onNestedScrollAccepted(child, target, axes);
    }

    int logNum;
}
