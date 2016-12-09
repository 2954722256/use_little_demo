package com.aohuan.dodo.rx.qt5.pic.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aohuan.dodo.rx.R;
import com.aohuan.dodo.rx.qt5.pic.Q1ShowPicActivity;
import com.aohuan.dodo.rx.qt5.pic.adapter.RvAdapter;
import com.aohuan.dodo.rx.qt5.pic.cont.MainContract;
import com.aohuan.dodo.rx.qt5.pic.model.MainModel;
import com.aohuan.dodo.rx.qt5.pic.utils.CommonBaseAdapter;
import com.aohuan.dodo.rx.qt5.pic.utils.RVItemDecoration;

import java.util.List;

/**
 * Created by dodo_lihao on 2016/12/9.
 * qq: 2390183798
 *       代码来自简书， 英勇青铜5 的文章 http://www.jianshu.com/p/4933445c71ed
 */
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private MainModel model;
    private RvAdapter adapter;

    public static MainPresenter newInstance(MainContract.View view) {
        return new MainPresenter(view);
    }

    private MainPresenter(MainContract.View view) {
        this.view = view;
        this.view.bindPresenter(this);
        this.view.initView();
        model = new MainModel();
    }

    @Override
    public void getRecyclerView(final RecyclerView recyclerView) {
        //设置RecyclerView配置
        GridLayoutManager manager = new GridLayoutManager(recyclerView.getContext(), 2);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new RVItemDecoration(16));
        //适配器
        adapter = new RvAdapter(recyclerView, R.layout.item_layout_q1);
        recyclerView.setAdapter(adapter);
        //点击事件
        adapter.setItemListener(new CommonBaseAdapter.onRecyclerItemClickerListener() {
            @Override
            public void onRecyclerItemClick(View view, Object data, int position) {
                if (null != data){
                    String picPath = (String) data;
                    startActivity(recyclerView.getContext(),picPath); //启动ShowPicActivity
                }
            }
        });
    }

    /**
     *  启动ShowPicActivity
     */
    private void startActivity(Context context,String picPath) {
        Intent intent = new Intent(context, Q1ShowPicActivity.class);
        Bundle bundle = new Bundle ();
        bundle.putString("picPath",picPath);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void load(final Activity activity) {
        if (view == null) return;
        model.loadPic(activity, new MainContract.MainBiz.onLoadPicListener() {
            @Override
            public void onLoadBefore() {
                view.showProgress();
            }//拿到图片路径集合前

            @Override
            public void onLoadAfter() {
                view.closeProgress();
            }//拿到图片路径集合后

            @Override
            public void onResult(List<String> picPathList) {//拿到图片路径集合
                if (adapter != null) adapter.setData(picPathList);
            }

            @Override
            public void onFailed(String info) {
                view.showInfo(info);
            }//获取图片路径失败
        });
    }

    @Override
    public void recycle() {
        if (model != null) model = null;
        if (view != null) view = null;
    }
}
