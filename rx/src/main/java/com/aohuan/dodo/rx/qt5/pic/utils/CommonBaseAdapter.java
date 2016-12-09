package com.aohuan.dodo.rx.qt5.pic.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by C.C on 2016/7/13.
 */

public abstract class CommonBaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    protected List<T> data = new ArrayList<>();
    protected int itemLayoutId;
    protected Context mContext;
    private onRecyclerItemClickerListener mListener;

    public CommonBaseAdapter(RecyclerView rv, int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
        this.mContext = rv.getContext();
    }

    public void setData(List<T> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    /**
     *  增加点击监听
     */
    public void setItemListener(onRecyclerItemClickerListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //这里不能使用两个参数的方法inflate（itemLayoutId，null）会导致item布局填充不满全屏
        View view = LayoutInflater.from(mContext).inflate(itemLayoutId, parent, false);
        BaseViewHolder baseViewHolder = new BaseViewHolder(view);
        baseViewHolder.setIsRecyclable(true);
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        bindViewData(holder, data.get(position), position);
        holder.itemView.setOnClickListener(getOnClickListener(position));
    }

    private View.OnClickListener getOnClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null && v != null) {
                    mListener.onRecyclerItemClick(v, data.get(position), position);
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public abstract void bindViewData(BaseViewHolder holder, T item, int position);

    public interface onRecyclerItemClickerListener {
        void onRecyclerItemClick(View view, Object data, int position);
    }
}
