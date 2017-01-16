package com.aohuan.dodo.dispatchevent_about.dummy_demo.view1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

import com.aohuan.dodo.common.utils.event.TouchEventUtil;

/**
 * Created by Administrator on 2016/8/28.
 */
public class MyWebView extends WebView {
    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    enum DoType{
        noting0, Disallow1, DisallowEnd2, DisallowEndTop3
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        doSth(DoType.DisallowEndTop3, ev);
        return super.onInterceptTouchEvent(ev);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        doSth3(ev);
//        return super.onTouchEvent(ev);
//    }

    void doSth(DoType dt, MotionEvent ev){
        switch (dt){
            case noting0:
                doSth0(ev);
                break;
            case Disallow1:
                doSth1(ev);
                break;
            case DisallowEnd2:
                doSth2(ev);
                break;
            case DisallowEndTop3:
                doSth3(ev);
                break;
        }
    }


    void doSth0(MotionEvent ev){}

    void doSth1(MotionEvent ev){
        this.requestDisallowInterceptTouchEvent(true);
    }

    void doSth2(MotionEvent ev){
        boolean isEnd = (getContentHeight()*getScale() - getHeight()-getScrollY() < 10);
        this.requestDisallowInterceptTouchEvent(!isEnd);
    }

    int moveOldY;
    int moveOldX;

    MovingBean oldBean;

    MovingBean getMovingBean(MotionEvent ev){
        if(oldBean == null){
            oldBean = new MovingBean(ev.getX(), ev.getY(), false, false, false);
            return oldBean;
        }

        MovingBean returnBean = oldBean;

        if(returnBean.getPositionY() - ev.getY() == 0){
            returnBean.setMoving(false);
//            oldBean.setToUp(false);
        }else if(ev.getY() - returnBean.getPositionY() > 0){
            returnBean.setMoving(true);
            returnBean.setToUp(false);
        }else{
            returnBean.setMoving(true);
            returnBean.setToUp(true);
        }

        if(returnBean.getPositionX() - ev.getX() == 0){
            //这里，前面判断过是否Moving， 如果为false， 还是false， 前面如果true， 还是true， 所以不用判断
            returnBean.setToRight(false);      //
        }else if(returnBean.getPositionY() - ev.getY() > 0){
            if(!returnBean.isMoving){
                returnBean.setMoving(true);
            }
            returnBean.setToRight(false);
        }else{
            if(!returnBean.isMoving){
                returnBean.setMoving(true);
            }
            returnBean.setToRight(true);
        }
        oldBean = returnBean;
        oldBean.setPositionX(ev.getX());
        oldBean.setPositionY(ev.getY());
        return returnBean;
    }

    void doSth3(MotionEvent ev){
        MovingBean movingBean = getMovingBean(ev);
        doSth31(movingBean, ev);
    }

    void doSth31(MovingBean movingBean, MotionEvent ev){
        if(movingBean == null || ev == null){
            return;
        }
//        if(!movingBean.isMoving){
//            return;
//        }
        if(!movingBean.isToUp()){
            TouchEventUtil.logActionMsg(getClass(), "doSth31  !movingBean.toDown", ev);
            boolean isStart = (getScrollY() == 0);
            this.requestDisallowInterceptTouchEvent(!isStart);
        }else{
            boolean isEnd = isEndCalc();
            this.requestDisallowInterceptTouchEvent(!isEnd);
        }

    }

    boolean isEndCalc(){
        Float calcDis = getContentHeight()*getScale() - getHeight() - getScrollY();
        if(Math.abs(Math.round(calcDis)) <= 10){
            return true;
        }
        return false;
    }



    class MovingBean {
        float positionX;
        float positionY;
        boolean isToUp;
        boolean isToRight;
        boolean isMoving;

        public MovingBean() {
        }

        public MovingBean(float positionX, float positionY, boolean isToUp, boolean isToRight, boolean isMoving) {
            this.positionX = positionX;
            this.positionY = positionY;
            this.isToUp = isToUp;
            this.isToRight = isToRight;
            this.isMoving = isMoving;
        }

        public float getPositionX() {
            return positionX;
        }

        public void setPositionX(float positionX) {
            this.positionX = positionX;
        }

        public float getPositionY() {
            return positionY;
        }

        public void setPositionY(float positionY) {
            this.positionY = positionY;
        }

        public boolean isToUp() {
            return isToUp;
        }

        public void setToUp(boolean toUp) {
            isToUp = toUp;
        }

        public boolean isMoving() {
            return isMoving;
        }

        public void setMoving(boolean moving) {
            isMoving = moving;
        }

        public boolean isToRight() {
            return isToRight;
        }

        public void setToRight(boolean toRight) {
            isToRight = toRight;
        }
    }

}
