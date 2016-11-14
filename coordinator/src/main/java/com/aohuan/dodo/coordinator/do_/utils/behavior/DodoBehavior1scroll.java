package com.aohuan.dodo.coordinator.do_.utils.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dodo  2390183798 on 2016/10/31.
 * 参考：  http://blog.csdn.net/qibin0506/article/details/50290421
 *
 * 对应的一起滑动的
 *      原理也简单， 是上下滑动， 就设置对应的y值为 Main View的y值
 *
 */
public class DodoBehavior1scroll extends CoordinatorLayout.Behavior<View> {

    public DodoBehavior1scroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
//        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
//        return false;
    }

//    @Override
//    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
//        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
//        int followScrolled = target.getScrollY();
//        child.setScrollY(followScrolled);
//    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        int followScrolled = target.getScrollY();
        child.setScrollY(followScrolled);
    }

    @Override
      public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        if(child instanceof NestedScrollView){
            ((NestedScrollView) child).fling((int)velocityY);
        }
        return true;
    }


}
