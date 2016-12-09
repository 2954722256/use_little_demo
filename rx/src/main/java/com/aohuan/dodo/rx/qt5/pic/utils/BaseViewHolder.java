package com.aohuan.dodo.rx.qt5.pic.utils;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by C.C on 2016/7/13.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> sparseArray;
    public BaseViewHolder(View itemView) {
        super(itemView);
        this.sparseArray = new SparseArray<>(8); //一般一个Item 不会超过8种控件
    }
    public <T extends View> T getView(int viewId){
        View view = sparseArray.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            sparseArray.put(viewId,view);
        }
        return (T) view;
    }
    public BaseViewHolder setText(int viewId , String text){
        TextView tv = getView(viewId);
        if (tv != null){
            tv.setText(text);
        }
        return this;
    }
}
