package com.aohuan.dodo.viewdemo.refresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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
 *  android:layout_height="0px"
 *  android:layout_weight="1"
 */
public class ReRv04Activity extends AppCompatActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {

    @InjectView(R.id.data)
    RecyclerView mRecycleView;
    @InjectView(R.id.refreshLayout)
    BGARefreshLayout mRefreshLayout;

    ArrayList<String> strArray = new ArrayList<>();
    private CommonAdapter mCommonAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_rv04);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        setData();
        setAdapter();
        setRefresh();
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

//        if(mCommonAdapter.getItemCount() > 30){
//            mRefreshLayout.endLoadingMore();
////            mZRefresh.setFooterTextOrImage("没有更多了哦～～", false);
//        }else{
//            strArray.add("dodoLoadMore " + ++nowInt);
//            mCommonAdapter.notifyDataSetChanged();
//            mRefreshLayout.endLoadingMore();
//        }
//        Toast.makeText(ReRv04Activity.this, "handler", Toast.LENGTH_SHORT).show();
//        mZRefresh.endRefreshOrLoad(mZRefresh.END_LOADING, TIME_DELAY);
        return true;
    }
}
