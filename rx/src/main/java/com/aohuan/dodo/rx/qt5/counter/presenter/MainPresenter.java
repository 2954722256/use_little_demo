package com.aohuan.dodo.rx.qt5.counter.presenter;

import android.app.Activity;
import android.widget.TextView;

import com.aohuan.dodo.rx.qt5.counter.cont.MainContract;
import com.aohuan.dodo.rx.qt5.counter.model.MainModel;

/**
 * Created by dodo_lihao on 2016/12/9.
 * qq: 2390183798
 *      代码来自简书， 英勇青铜5 的文章 http://www.jianshu.com/p/ccd999c7b66a
 */
public class MainPresenter implements MainContract.IPresenter {
    private MainContract.IMainView view;
    private MainModel model;
    private TextView tv;

    public static MainPresenter newInstance(MainContract.IMainView view) {
        return new MainPresenter(view);
    }

    public MainPresenter(MainContract.IMainView view) {
        this.view = view;
        this.view.bindPresenter(this);
        model = new MainModel();
    }

    @Override
    public void initView(TextView tv) {
        this.tv = tv;
    }


    @Override
    public void startByHandler(Activity activity) {
        model.onStartByHandler(activity,new MainContract.IMainBiz.onStartListener() {
            @Override
            public void start(String time) {
                if (view != null) {
                    view.initView();
                    if (tv != null) {
                        tv.setText(time);
                    }
                }
            }
        });
    }

    @Override
    public void startByThread(Activity activity) {
        model.onStartByThread(activity,new MainContract.IMainBiz.onStartListener() {
            @Override
            public void start(String time) {
                if (view != null) {
                    view.initView();
                    if (tv != null) {
                        tv.setText(time);
                    }
                }
            }
        });
    }

    @Override
    public void stop() {
        model.onStop(new MainContract.IMainBiz.onStopListener() {
            @Override
            public void stop(String info, boolean b) {
                if (view != null)
                    view.onStop(info, b);
            }
        });
    }


    @Override
    public void onRecycler() {
        if (model != null) model = null;
        if (view != null) view = null;
    }

    @Override
    public void atFirst() { }
}
