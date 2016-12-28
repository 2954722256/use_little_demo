package com.aohuan.dodo.viewdemo.refresh;

import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.listabout.rv.hy.utils.DividerItemDecoration;
import com.aohuan.dodo.viewdemo.refresh.utils.DemoLoadMoreView;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.lhh.ptrrv.library.footer.loadmore.BaseLoadMoreView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ReRv03Activity extends AppCompatActivity {

    @InjectView(R.id.ptrrv)
    com.lhh.ptrrv.library.PullToRefreshRecyclerView mPtrrv;

    CommonAdapter mCommonAdapter;

    ArrayList<String> strArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_rv03);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        setRefresh();
        setData();
        setRv();
    }


    private void setRefresh() {
//        mSwipeRefreshWidget.setRefreshing(false);
//        mSwipeRefreshWidget.setSize(SwipeRefreshLayout.DEFAULT);
//        mSwipeRefreshWidget.setColorSchemeResources(
//                android.R.color.holo_blue_bright,
//                android.R.color.holo_green_light,
//                android.R.color.holo_orange_light,
//                android.R.color.holo_red_light);
//        mSwipeRefreshWidget.setProgressBackgroundColor(R.color.red);
//        mSwipeRefreshWidget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
////                mSwipeRefreshWidget.setEnabled(false);
//                mHandler.sendEmptyMessageDelayed(MSG_CODE_REFRESH, TIME_DELAY);
//            }
//        });

        // 1 custom own load-more-view and add it into ptrrv
        DemoLoadMoreView loadMoreView = new DemoLoadMoreView(this, mPtrrv.getRecyclerView());
        loadMoreView.setLoadmoreString("loading");
        loadMoreView.setLoadMorePadding(100);
        // 2 set the layoutManager which to use
        mPtrrv.setLayoutManager(new LinearLayoutManager(this));
        mPtrrv.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener() {
            @Override
            public void onLoadMoreItems() {
                //do loadmore here
                mHandler.sendEmptyMessageDelayed(MSG_CODE_MORE, TIME_DELAY);
            }
        });
        mPtrrv.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.sendEmptyMessageDelayed(MSG_CODE_REFRESH, TIME_DELAY);
            }
        });
        mPtrrv.getRecyclerView().addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        //3 set EmptyVIEW（no header）
        mPtrrv.setEmptyView(View.inflate(this, R.layout.empty_common_view_re, null));
        mPtrrv.setLoadMoreFooter(loadMoreView);

    }

    private void setRv() {

        mPtrrv.setAdapter(mCommonAdapter = new CommonAdapter<String>(this, R.layout.item_rv_o1_1, strArray) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.teach_item_name, item);
            }
        });

        // set loadmore enable, onFinishLoading(can load more? , select before item)
        mPtrrv.onFinishLoading(true, false);

        mPtrrv.setSwipeEnable(true);//open swipe
    }

    int anInt = 3;
    int nowInt = 0;
    private void setData() {
        strArray.clear();
        for (int i = 0; i < anInt; i++) {
            nowInt = i ;
            strArray.add("dodo " + i);
        }
        if(anInt < 10){
            anInt += 2;
        }else{
            anInt = 3;
        }
    }


    public static final int MSG_CODE_REFRESH = 0;
    public static final int MSG_CODE_MORE = 0;
    private static final int TIME_DELAY = 1000;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG_CODE_REFRESH) {
                setData();
                mCommonAdapter.notifyDataSetChanged();
                mPtrrv.setRefreshing(false);
            }else if(msg.what == MSG_CODE_MORE){
                if(mCommonAdapter.getItemCount() > 30){
                    mCommonAdapter.notifyDataSetChanged();
                    mPtrrv.onFinishLoading(false, false);
                }else{
                    strArray.add("dodoLoadMore " + ++nowInt);
                    mCommonAdapter.notifyDataSetChanged();
                    mPtrrv.onFinishLoading(true, false);
                }

            }
        }
    };
}
