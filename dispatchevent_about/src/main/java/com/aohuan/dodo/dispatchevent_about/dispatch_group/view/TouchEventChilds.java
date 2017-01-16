package com.aohuan.dodo.dispatchevent_about.dispatch_group.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aohuan.dodo.dispatchevent_about.dispatch_group.tools.TouchEventUtil;


public class TouchEventChilds extends LinearLayout {

	private final Context mContext;

	public TouchEventChilds(Context context) {
		super(context);
		this.mContext = context;
	}

	public TouchEventChilds(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
//		this.setClickable(false);
//		this.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				TouchEventUtil.logActionMsg(TouchEventChilds.class, "TouchEventChilds setOnClickListener  onClick", null);
//			}
//		});
//		this.setOnTouchListener(new OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				TouchEventUtil.logActionMsg(TouchEventChilds.class, "TouchEventChilds setOnTouchListener  onTouch", event);
//				return false;
//			}
//		});
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		TouchEventUtil.logActionMsg(getClass(), "onInterceptTouchEvent", ev);
		this.requestDisallowInterceptTouchEvent(true);
//		if(getParent()!=null){
//			getParent().requestDisallowInterceptTouchEvent(true);
//			TouchEventUtil.logActionMsg(getClass(),"onInterceptTouchEvent  requestDisallowInterceptTouchEvent  true",ev);
//		}
		return super.onInterceptTouchEvent(ev);
//		return true;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		TouchEventUtil.logActionMsg(getClass(),"dispatchTouchEvent",ev);
		this.requestDisallowInterceptTouchEvent(true);
//		if(getParent()!=null){
//			getParent().requestDisallowInterceptTouchEvent(true);
//			TouchEventUtil.logActionMsg(getClass(),"onInterceptTouchEvent  requestDisallowInterceptTouchEvent  true",ev);
//		}
		return super.dispatchTouchEvent(ev);
//		return false;
//		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		TouchEventUtil.logActionMsg(getClass(),"onTouchEvent",ev);
		this.requestDisallowInterceptTouchEvent(true);
//		if(getParent()!=null){
//			getParent().requestDisallowInterceptTouchEvent(true);
//			TouchEventUtil.logActionMsg(getClass(),"onInterceptTouchEvent  requestDisallowInterceptTouchEvent  true",ev);
//		}
		return super.onTouchEvent(ev);
//		return true;
	}





	Button isNullButtonView;

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		if(getChildAt(0) != null && getChildAt(0) instanceof Button){
			isNullButtonView = (Button) getChildAt(0);
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		//Apply the whole area of this view as the delegate area
		if(isNullButtonView != null){
			Rect bounds = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
			TouchDelegate delegate = new TouchDelegate(bounds, isNullButtonView);
			setTouchDelegate(delegate);
		}
	}


	@Override
	public void setPadding(int left, int top, int right, int bottom) {
		super.setPadding(left, top, right, bottom);
	}

	@Override
	public void setPaddingRelative(int start, int top, int end, int bottom) {
		super.setPaddingRelative(start, top, end, bottom);
	}



}
