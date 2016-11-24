package com.example.admin.viewabout.utils.view;

import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by dodo_lihao on 2016/11/14.
 * qq: 2390183798
 */
public class VerticalMoveFrameLayout extends FrameLayout  implements NestedScrollingChild {


    private int lastY;

    public VerticalMoveFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerticalMoveFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_MOVE:
                MarginLayoutParams layoutParams = (MarginLayoutParams) getLayoutParams();
                int top = layoutParams.topMargin + y - lastY;
                layoutParams.topMargin = top;
                setLayoutParams(layoutParams);
                requestLayout();
                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        lastY = y;
        return true;
    }

}
