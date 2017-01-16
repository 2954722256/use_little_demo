package com.aohuan.dodo.dispatchevent_about.dispatch_group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.aohuan.dodo.dispatchevent_about.R;
import com.aohuan.dodo.dispatchevent_about.dispatch_group.tools.TouchEventUtil;


public class A01Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a01);

        setButton();
        setGroupListenr();
    }

    private void setGroupListenr() {
//        setViewListener(findViewById(R.id.father), "father");
        setViewListener(findViewById(R.id.childs), "childs");

//        findViewById(R.id.childs2).setClickable(false);
//        setViewListener(findViewById(R.id.childs2), "childs2");
//        findViewById(R.id.childs2).setClickable(false);
    }

    private void setViewListener(final View view, final String viewName){
        if(view == null){
            return;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TouchEventUtil.logActionMsg(A01Activity.class, viewName + " setOnClickListener  onClick", null);
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                TouchEventUtil.logActionMsg(A01Activity.class, viewName + " setOnTouchListener  onTouch", event);
                return false;
            }
        });
    }

    private void setButton() {
//        View view = findViewById(R.id.testBtn);
//        setViewListener(view, "btn");
//
//        View view2 = findViewById(R.id.testLl);
//        setViewListener(view2, "LL");

//        setViewListener(findViewById(R.id.allRl), "OutPlant");

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        TouchEventUtil.logActionMsg(getClass(),"onTouchEvent",ev);
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        TouchEventUtil.logActionMsg(getClass(),"dispatchTouchEvent",ev);
        return super.dispatchTouchEvent(ev);
    }


    /**
     * 把 打印切换成【down】
     * 只是自定义的Button的自定义View
     * 重写了   dispatchTouchEvent     onTouchEvent 方法
     */
    public static void doSth0(){
    }


    /**
     * 把 打印切换成【down】
     * 所有的都是默认， 没有别的操作
     * (主旨： 说明 dispatchTouchEvent  onTouchEvent 的过程)
     * 1.1   Activity 点击，    先 （Activity）dispatchTouchEvent，   再 （Activity）onTouchEvent
     *                  我们知道，先通过 dispatchTouchEvent 下发事件，  再通过 onTouchEvent 触发事件
     * 1.2   Father  点击，  （MainActivity）dispatchTouchEvent，（TouchEventFather）dispatchTouchEvent，（TouchEventFather）onInterceptTouchEvent，（TouchEventFather）onTouchEvent，（MainActivity）onTouchEvent，
     *                  我们知道，Activity没有 onIntercept拦截器，  其他的，每次 dispatchTouchEvent之后，都有一个 onInterceptTouchEvent 拦截判断
     *                                                          （如果拦截， 就不会走子View的 onTouchEvent ，  如果不拦截， 会走子view的 onTouchEvent ）
     *
     * 1.3  Child   点击， 不写了， 可以知道一连串的事件
     *
     *1.4   Child2  点击， 不写了， 可以知道一连串的事件
     */
    public static void doSth1(){
    }


    /**
     * 把 打印切换成【down】
     * 这里测试 onIntercept 拦截器， 如果 onIntercept 为 true，
     * 2.1  Father 设置 onInterceptTouchEvent 为true， 也就是 不向下传递， 但是，可以回传
     *              我们可以发现，对应的 Event传递， 到当前就结束， 并且回传了
     *
     * 2.2  Child 设置 onInterceptTouchEvent 为true，   Father 设置回来，
     *              我们可以发现，对应的 Event传递， 到当前就结束， 并且回传了， 当然到了Child以后
     *
     *  【注意：】   这里 Activity 和 最下层的Button 是没有 onInterceptTouchEvent 方法的
     *                  Activity是为了向下传递，所以自己没有
     *                  Button是一个View ，不是ViewGroup， 不会有 子View， 所以不会有 onInterceptTouchEvent 方法
     */
    public static void doSth2(){
    }


    /**
     * 把 打印切换成【down】
     * 消费
     *
     */
    public static void doSth3(){
    }



    /**
     * 把 打印切换成【down】
     */
    public static void doSth4(){
    }

}
