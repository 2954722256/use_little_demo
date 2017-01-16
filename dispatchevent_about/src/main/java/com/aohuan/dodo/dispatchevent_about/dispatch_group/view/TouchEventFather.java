package com.aohuan.dodo.dispatchevent_about.dispatch_group.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.aohuan.dodo.dispatchevent_about.dispatch_group.tools.TouchEventUtil;


public class TouchEventFather extends LinearLayout {

	private final Context mContext;

	public TouchEventFather(Context context) {
		super(context);
		this.mContext = context;
	}

	public TouchEventFather(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
//		this.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				TouchEventUtil.doClick(TouchEventFather.class);
//			}
//		});
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		TouchEventUtil.logActionMsg(getClass(), "dispatchTouchEvent", ev);
		return super.dispatchTouchEvent(ev);
//		return false;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		TouchEventUtil.logActionMsg(getClass(),"onInterceptTouchEvent",ev);
//		return super.onInterceptTouchEvent(ev);
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		TouchEventUtil.logActionMsg(getClass(),"onTouchEvent",ev);
		return super.onTouchEvent(ev);
	}


}
