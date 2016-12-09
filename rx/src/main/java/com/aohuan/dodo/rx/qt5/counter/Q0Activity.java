package com.aohuan.dodo.rx.qt5.counter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aohuan.dodo.rx.R;
import com.aohuan.dodo.rx.qt5.counter.cont.MainContract;
import com.aohuan.dodo.rx.qt5.counter.presenter.MainPresenter;
import com.aohuan.dodo.rx.qt5.counter.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 简单理解mvp的例子
 *      代码来自简书， 英勇青铜5 的文章 http://www.jianshu.com/p/ccd999c7b66a
 */
public class Q0Activity extends AppCompatActivity implements MainContract.IMainView {

    @InjectView(R.id.tv_time_main_activity)
    TextView tvTimeMainActivity;
    @InjectView(R.id.bt_handler_main_activity)
    Button btHandlerMainActivity;
    @InjectView(R.id.bt_thread_main_activity)
    Button btThreadMainActivity;
    @InjectView(R.id.bt_stop_main_activity)
    Button btStopMainActivity;

    MainContract.IPresenter presenter;
    private boolean isHasClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q0);
        ButterKnife.inject(this);

        //初始化MainPresenter
        MainPresenter.newInstance(this);
    }


    @Override
    public void initView() {
        if (tvTimeMainActivity != null && presenter != null)
            presenter.initView(tvTimeMainActivity);
    }

    @Override
    public void onStop(String info, boolean b) {
        isHasClicked = b;
        ToastUtils.show(this, info);
    }

    @Override
    public void bindPresenter(MainContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @OnClick({R.id.tv_time_main_activity, R.id.bt_handler_main_activity, R.id.bt_thread_main_activity, R.id.bt_stop_main_activity})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_time_main_activity:
                break;
            case R.id.bt_handler_main_activity:
                if (presenter != null && !isHasClicked) {
                    isHasClicked = true;
                    presenter.startByHandler(this);
                }
                break;
            case R.id.bt_thread_main_activity:
                if (presenter != null && !isHasClicked) {
                    isHasClicked = true;
                    presenter.startByThread(this);
                }
                break;
            case R.id.bt_stop_main_activity:
                if (presenter != null) {
                    presenter.stop();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) presenter.onRecycler();
    }
}
