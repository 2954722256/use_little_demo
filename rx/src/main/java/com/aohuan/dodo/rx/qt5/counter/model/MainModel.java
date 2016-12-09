package com.aohuan.dodo.rx.qt5.counter.model;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

import com.aohuan.dodo.rx.qt5.counter.cont.MainContract;
import com.aohuan.dodo.rx.qt5.counter.utils.ThreadUtils;
import com.aohuan.dodo.rx.qt5.counter.utils.TimeUitls;

import java.lang.ref.WeakReference;

/**
 * Created by dodo_lihao on 2016/12/9.
 * qq: 2390183798
 *       代码来自简书， 英勇青铜5 的文章 http://www.jianshu.com/p/ccd999c7b66a
 */
public class MainModel implements MainContract.IMainBiz {
    private onStartListener onStartListener;
    private static final int MSG_WHAT_THREAD = 102;
    private int currentTime;
    private int type = 0;
    private final int TYPE_DEFAULT = 0;
    private final int TYPE_HANDLER = 1;
    private final int TYPE_THREAD = 2;
    private final String THREAD_NAME = "thread_time";
    private StaticHandler handler = null;

    public static class StaticHandler extends Handler {
        private final WeakReference<Activity> mActivity;
        public StaticHandler(Activity activity) {
            mActivity = new WeakReference<>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Activity mainActivity = mActivity.get();
            MainContract.IMainBiz.onStartListener onStartListener = (MainContract.IMainBiz.onStartListener) msg.obj;
            if (mainActivity != null && onStartListener != null) {
                if (msg.what == MSG_WHAT_THREAD) {
                    onStartListener.start(TimeUitls.milliSecondToMinute(msg.arg1));
                }
            }
        }
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            onStartListener.start(TimeUitls.milliSecondToMinute(currentTime));
            long now = SystemClock.uptimeMillis();
            long next = now + (1000 - now % 1000);
            currentTime += 1000;
            handler.postAtTime(runnable, next);
        }
    };
    /**
     * 使用Handler方式
     */
    @Override
    public void onStartByHandler(Activity mainActivity, onStartListener onStartListener) {
        if (this.onStartListener == null) {
            this.onStartListener = onStartListener;
            type = TYPE_HANDLER;
            handler = new StaticHandler(mainActivity);
            handler.post(runnable);
        }
    }
    /**
     * 使用单独开启线程
     */
    @Override
    public void onStartByThread(Activity activity, final onStartListener onStartListener) {
        if (this.onStartListener == null) {
            handler = new StaticHandler(activity);
            this.onStartListener = onStartListener;
            type = TYPE_THREAD;
            ThreadUtils.newThread(THREAD_NAME, new Runnable() {
                @Override
                public void run() {
                    while (ThreadUtils.isAlive(THREAD_NAME)) {
                        Message message = handler.obtainMessage();
                        message.what = MSG_WHAT_THREAD;
                        message.obj = onStartListener;
                        message.arg1 = currentTime;
                        handler.sendMessage(message);
                        currentTime += 1000;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
    @Override
    public void onStop(MainContract.IMainBiz.onStopListener onStopListener) {
        if (type == TYPE_DEFAULT) {
            onStopListener.stop("计时还没有开始", false);
            return;
        }
        if (type == TYPE_HANDLER) {
            handler.removeCallbacks(runnable);
        } else if (type == TYPE_THREAD) {
            ThreadUtils.killThread(THREAD_NAME);
        }
        onStopListener.stop("计时结束", false);
        currentTime = 0;
        onStartListener = null;
        type = TYPE_DEFAULT;
    }
}
