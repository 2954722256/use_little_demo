package com.aohuan.dodo.coordinator.do_.utils.behavior;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by dodo on 2016/11/1.
 * qq: 2390183798
 *
 *
 * 根据MainView竖直方向的滑动， 设置绑定View的宽度
 *      原理也简单， 只要是竖直滑动， 动态设置宽， 添加是否可见，以及简单动画，即可
 */
public class DodoMoveBigerBehavior extends CoordinatorLayout.Behavior<View> {

    public DodoMoveBigerBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }


    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        int followScrolled = target.getScrollY();
            setBiger(child, followScrolled);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        int followScrolled = target.getScrollY();
        setBiger(child, followScrolled);
        return true;
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);
        int followScrolled = target.getScrollY();
        setBiger(child, followScrolled);
    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        int followScrolled = target.getScrollY();
        setBiger(child, followScrolled);
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    final int MinWidth = 300;
    final int MaxWidth = 450;

    private void setBiger(View v, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) v.getLayoutParams();
        layoutParams.width = 200 + y/10;

//        if(layoutParams.width >= MinWidth && layoutParams.width <= MaxWidth){
//            v.setVisibility(View.VISIBLE);
//        }else{
//            v.setVisibility(View.GONE);
//        }

        doJudge(v, layoutParams.width);

        v.setLayoutParams(layoutParams);
    }

    private int oldY = 0;
    private boolean isMinBiggerAni = false;
    private boolean isMaxBiggerAni = false;

    private void doJudge(View v, int y){
        Log.e("ani", "y : " +y + "  ==  oldY : " + oldY);
        if(oldY < y){
            if(y >= MinWidth && !isMinBiggerAni){
                isMinBiggerAni = !isMinBiggerAni;
                v.setVisibility(View.VISIBLE);
                doAnimat(v, true);
                Log.e("ani", "now");
            }
            if(y >= MaxWidth && !isMaxBiggerAni){
                isMaxBiggerAni = !isMaxBiggerAni;
                doAnimat(v, false);
                Log.e("ani", "now");
            }
        }

        if(oldY > y){
            if(y < MinWidth && isMinBiggerAni){
                isMinBiggerAni = !isMinBiggerAni;
                doAnimat(v, false);
                Log.e("ani", "now");
            }
            if(y < MaxWidth && isMaxBiggerAni){
                isMaxBiggerAni = !isMaxBiggerAni;
                doAnimat(v, true);
                v.setVisibility(View.VISIBLE);
                Log.e("ani", "now");
            }
        }
        oldY = y;
    }


    private void doAnimat(View v, boolean isBigger){
        ObjectAnimator fViewScaleXAnim = ObjectAnimator.ofFloat(v,"scaleX",isBigger?0f:1f, isBigger?1f:0f);
        fViewScaleXAnim.setDuration(500);
        fViewScaleXAnim.start();
    }

}
