package com.aohuan.demo.stickynav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/10/24.
 */
public class StickyNavLayoutView extends LinearLayout {
    LinearLayout id_topview;
    LinearLayout id_indicatorview;
    ListView id_bottomview;

    public StickyNavLayoutView(Context context) {
        this(context, null);
    }
    public StickyNavLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        setOrientation(VERTICAL);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        id_topview= (LinearLayout) findViewById(R.id.id_topview);
        id_indicatorview= (LinearLayout) findViewById(R.id.id_indicatorview);
        id_bottomview= (ListView) findViewById(R.id.id_bottomview);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
    }

    int mTopViewHeight = 0;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mTopViewHeight=id_topview.getMeasuredHeight();
        LayoutParams params= (LayoutParams) id_bottomview.getLayoutParams();
        params.height=getMeasuredHeight()-id_indicatorview.getMeasuredHeight();
    }

}
