package com.aohuan.dodo.viewdemo.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aohuan.dodo.viewdemo.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGAStickinessRefreshViewHolder;


/**
 * 注意 xml 需要设置
 * <android.support.v7.widget.RecyclerView
 * android:layout_height="0px"
 * android:layout_weight="1"
 */
public class ReRv06Activity extends AppCompatActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tv1)
    TextView tv1;
    @InjectView(R.id.abl)
    AppBarLayout abl;
    @InjectView(R.id.m_recycler_view)
    RecyclerView mRecycleView;
    @InjectView(R.id.mBGARefreshLayout)
    BGARefreshLayout mRefreshLayout;

    ArrayList<String> strArray = new ArrayList<>();
    private CommonAdapter mCommonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_rv06);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        initToolbar();
        setData();
        setAdapter();
        setRefresh();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv1.setText("type : no");
    }


    private void setAdapter() {
        mRefreshLayout.setDelegate(this);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(mCommonAdapter = new CommonAdapter<String>(this, R.layout.item_rv_o1_1, strArray) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.teach_item_name, item);
            }
        });
    }

    private void setRefresh() {
        BGAStickinessRefreshViewHolder stickinessRefreshViewHolder = new BGAStickinessRefreshViewHolder(this, true);
        stickinessRefreshViewHolder.setStickinessColor(R.color.colorPrimary);
        stickinessRefreshViewHolder.setRotateImage(R.mipmap.bga_refresh_stickiness);
        mRefreshLayout.setRefreshViewHolder(stickinessRefreshViewHolder);
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
                setData();
                mCommonAdapter.notifyDataSetChanged();
                mRefreshLayout.endRefreshing();
            }else if(msg.what == MSG_CODE_MORE){
                if(mCommonAdapter.getItemCount() > 30){
                    mRefreshLayout.endLoadingMore();
                } else {
                    strArray.add("dodoLoadMore " + ++nowInt);
                    mCommonAdapter.notifyDataSetChanged();
                    mRefreshLayout.endLoadingMore();
                }
            }
        }
    };

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mHandler.sendEmptyMessageDelayed(MSG_CODE_REFRESH, TIME_DELAY);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        mHandler.sendEmptyMessageDelayed(MSG_CODE_MORE, TIME_DELAY);
        return true;
    }


}
