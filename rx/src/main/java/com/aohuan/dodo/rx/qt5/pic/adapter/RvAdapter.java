package com.aohuan.dodo.rx.qt5.pic.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.aohuan.dodo.rx.R;
import com.aohuan.dodo.rx.qt5.pic.utils.BaseViewHolder;
import com.aohuan.dodo.rx.qt5.pic.utils.CommonBaseAdapter;
import com.bumptech.glide.Glide;

/**
 * Created by dodo_lihao on 2016/12/9.
 * qq: 2390183798
 */
public class RvAdapter extends CommonBaseAdapter<String> {
    private Activity activity;
    public RvAdapter(RecyclerView rv, int itemLayoutId) {
        super(rv, itemLayoutId);
        activity = (Activity) rv.getContext();
    }

    @Override
    public void bindViewData(BaseViewHolder holder, final String item, int position) {
        final ImageView iv = holder.getView(R.id.iv_item_rv_layout);
        iv.post(new Runnable() {
            @Override
            public void run() {
                Glide.with(activity).load(item).override(iv.getWidth(),iv.getHeight()).into(iv);
            }
        }) ;
    }
}