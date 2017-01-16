package com.aohuan.dodo.dispatchevent_about.dispatch_group.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.aohuan.dodo.dispatchevent_about.dispatch_group.tools.TouchEventUtil;


public class TouchEventChilds2 extends Button {

    Context mContext;

    public TouchEventChilds2(Context context) {
        super(context);
        this.mContext = context;
    }

    public TouchEventChilds2(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
//        this.setClickable(false);
//        this.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TouchEventUtil.doClick(TouchEventChilds2.class);
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        TouchEventUtil.logActionMsg(getClass(), "dispatchTouchEvent", ev);
//        if(getParent()!=null){
//            getParent().requestDisallowInterceptTouchEvent(true);
//            TouchEventUtil.logActionMsg(getClass(),"dispatchTouchEvent requestDisallowInterceptTouchEvent true ",ev);
//        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        TouchEventUtil.logActionMsg(getClass(),"onTouchEvent",ev);
//        if(getParent()!=null){
//            getParent().requestDisallowInterceptTouchEvent(true);
//            TouchEventUtil.logActionMsg(getClass(),"onInterceptTouchEvent  requestDisallowInterceptTouchEvent  true",ev);
//        }
        return super.onTouchEvent(ev);
    }


}
