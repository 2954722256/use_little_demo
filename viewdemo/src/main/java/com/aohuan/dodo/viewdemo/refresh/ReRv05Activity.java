package com.aohuan.dodo.viewdemo.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.refresh.bga.ZhyBgaRefresh;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 注意 xml 需要设置
 * <android.support.v7.widget.RecyclerView
 *  android:layout_height="0px"
 *  android:layout_weight="1"
 */
public class ReRv05Activity extends AppCompatActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {

    @InjectView(R.id.data)
    RecyclerView mRecycleView;
    @InjectView(R.id.refreshLayout)
    cn.bingoogolapple.refreshlayout.BGARefreshLayout mRefresh;

    private ZhyBgaRefresh mZRefresh;
    ArrayList<String> strArray = new ArrayList<>();
    CommonAdapter mCommonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_rv05);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        setData();
        initBga();
    }

    private void initBga() {
        mZRefresh = new ZhyBgaRefresh(this, mRefresh, true);
        mRefresh.setRefreshViewHolder(mZRefresh);
        mRefresh.setDelegate(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(mCommonAdapter = new CommonAdapter<String>(this, R.layout.item_rv_o1_1, strArray) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.teach_item_name, item);
            }
        });

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
    public static final int MSG_CODE_MORE = 1;
    private static final int TIME_DELAY = 1000;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG_CODE_REFRESH) {

            }else if(msg.what == MSG_CODE_MORE){
                strArray.add("dodoLoadMore " + ++nowInt);
                mCommonAdapter.notifyDataSetChanged();
                mZRefresh.endRefreshOrLoad(mZRefresh.END_LOADING, TIME_DELAY);

            }
        }
    };


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        setData();
        mZRefresh.endRefreshOrLoad(mZRefresh.END_REFRESH, TIME_DELAY);
        mCommonAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        if(mCommonAdapter.getItemCount() > 30){
            mZRefresh.setFooterTextOrImage("没有更多了哦～～", false);
        }else{
            mZRefresh.setFooterTextOrImage("正在玩命加载中...", true);
        }


        mHandler.sendEmptyMessageDelayed(MSG_CODE_MORE, TIME_DELAY);
        return true;
    }

}
