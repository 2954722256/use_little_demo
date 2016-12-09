package com.aohuan.dodo.rx.qt5.pic;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.aohuan.dodo.rx.R;
import com.aohuan.dodo.rx.qt5.pic.cont.MainContract;
import com.aohuan.dodo.rx.qt5.pic.presenter.MainPresenter;
import com.aohuan.dodo.rx.qt5.pic.utils.ToastUtils;

public class Q1Activity extends AppCompatActivity implements MainContract.View {
    private MainContract.Presenter presenter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        init();
    }

    //初始化
    private void init() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl_main_activity);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);
        swipeRefreshLayout.setEnabled(false);//禁止下拉刷新
//        swipeRefreshLayout.setEnabled(true);//

        recyclerView = (RecyclerView) findViewById(R.id.rv_main_activity);

        MainPresenter.newInstance(this);
        if (presenter != null) presenter.load(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) presenter.recycle();
        if (recyclerView != null) recyclerView.setAdapter(null);
    }

    //显示SwipeRefreshLayout的圆圈
    @Override
    public void showProgress() {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
                }
            });
        }
    }
    //关闭SwipeRefreshLayout的圆圈
    @Override
    public void closeProgress() {
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showInfo(String info) {
        ToastUtils.show(this, info);
    }

    @Override
    public void bindPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void initView() {
        if (presenter != null && recyclerView != null)
            presenter.getRecyclerView(recyclerView);
    }
}
