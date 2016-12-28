package com.aohuan.dodo.viewdemo.refresh.bga;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aohuan.dodo.viewdemo.R;

import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 *
 */
public class ZhyBgaRefresh extends BGAMoocStyleRefreshViewHolder {
    private ImageView mFooterDataImage;
    private ImageView mFooterNoDataImage;
    private TextView mFooterText;
    private BGARefreshLayout mRefresh;
    public  final int END_REFRESH= 1;
    public  final int END_LOADING= 2;
    public ZhyBgaRefresh(Context context, BGARefreshLayout refresh, boolean isLoadingMoreEnabled) {
        super(context, isLoadingMoreEnabled);
        mRefresh = refresh;
        initTopView(context);
        initFooterView(context);
    }

    private void initFooterView(Context context) {
        mLoadMoreFooterView= LayoutInflater.from(context).inflate(R.layout.layout_bga_footer_anim, null);
        mFooterDataImage= (ImageView) mLoadMoreFooterView.findViewById(R.id.m_data_image);
        mFooterNoDataImage = (ImageView) mLoadMoreFooterView.findViewById(R.id.m_no_data_image);
        mFooterText= (TextView) mLoadMoreFooterView.findViewById(R.id.m_text);
        AnimationDrawable animationDrawable= (AnimationDrawable) mFooterDataImage.getDrawable();
        animationDrawable.start();
    }

    public void setFooterTextOrImage(String content, boolean isShow){
        mFooterText.setText(content);
        mFooterDataImage.setVisibility(isShow == true ? View.VISIBLE : View.GONE);
        mFooterNoDataImage.setVisibility(isShow == true ? View.GONE : View.VISIBLE);
    }

    private void initTopView(Context context) {
        this.setUltimateColor(R.color.custom_imoocstyle);
        this.setOriginalImage(R.mipmap.bga_refresh_moooc);
        this.setSpringDistanceScale(0.2f);
    }

    public void endRefreshOrLoad(int end, int millisecond ){
        mHandler.sendEmptyMessageDelayed(end, millisecond);
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case END_REFRESH:
                    mRefresh.endRefreshing();
                    break;
                case END_LOADING:
                    mRefresh.endLoadingMore();
                    break;
            }
            super.handleMessage(msg);
        }
    };

}
