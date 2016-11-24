package com.aohuan.dodo.coordinator.dob.utils.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.aohuan.dodo.coordinator.utils.LogE;

/**
 * Created by dodo_lihao on 2016/11/14.
 * qq: 2390183798
 */
public class NestDodoSChild1 extends ScrollView implements NestedScrollingChild {

    private static final String TAG = NestDodoSChild1.class.getSimpleName();

    private NestedScrollingChildHelper mChildHelper;

    private int[] mConsumed = new int[2];   //消费了的
    private int[] mOffset = new int[2];

    View v;

    private int lastY;
    private int mActivePointerId = -1;  // -1 为无效非法id

    private final int[] mScrollOffset = new int[2];
    private final int[] mScrollConsumed = new int[2];
    private int mNestedYOffset;

    public NestDodoSChild1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NestDodoSChild1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mChildHelper = new NestedScrollingChildHelper(this);
        mChildHelper.setNestedScrollingEnabled(true);
    }

    @Override
    public boolean startNestedScroll(int axes) {
        LogE.logT(TAG, "startNestedScroll " + logNum++);
        return mChildHelper.startNestedScroll(axes);
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        LogE.logT(TAG, "dispatchNestedScroll " + logNum++);
        return mChildHelper.dispatchNestedScroll(dxConsumed,dyConsumed, dxUnconsumed,dyUnconsumed,offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        LogE.logT(TAG, "dispatchNestedPreScroll " + logNum++);
        return mChildHelper.dispatchNestedPreScroll(dx,dy, consumed,offsetInWindow);
    }

    int mLastMotionY=0;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:

                mLastMotionY= (int) ev.getY();
                mActivePointerId = ev.getPointerId(0);
                startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
                break;
            case MotionEvent.ACTION_MOVE:

//                int extraY = startY-(int) ev.getY();
//                dispatchNestedPreScroll(0,extraY,mConsumed,mOffset);
//                startY = (int) event.getY();
//
//                //NestScrollingLayout移动之后的偏移量
//                Log.d(TAG, "offset--x:" + mOffset[0] + ",offset--y:" + mOffset[1]);
////                dispatchNestedScroll(50,50,50,50,mOffset);
//                dispatchNestedScroll(50,50,50,50,mOffset);



                final int y = (int) ev.getY();
                int deltaY = mLastMotionY - y;
                dispatchNestedPreScroll(0, deltaY, mScrollConsumed, mScrollOffset);
                deltaY -= mScrollConsumed[1];

                dispatchNestedScroll(0, deltaY, 0, mScrollConsumed[1], mScrollOffset);


                break;
            case MotionEvent.ACTION_UP:
                mChildHelper.stopNestedScroll();
                break;

            case MotionEvent.ACTION_CANCEL:
                mChildHelper.stopNestedScroll();
                break;
            default:
                break;
        }
        return true;
    }

    int logNum;

}
