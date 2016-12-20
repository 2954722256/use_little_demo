package com.aohuan.dodo.viewdemo.listabout.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dodo_lihao on 2016/12/19.
 * qq: 2390183798
 */
public abstract class PreBaseHolder extends RecyclerView.ViewHolder{
    public PreBaseHolder(View itemView){

        super(itemView);
    }

    public BaseHolder get(Context context, ViewGroup parent, int type){
        return onCreateHolder(context, parent, type);
    }

    abstract BaseHolder onCreateHolder(Context context, ViewGroup parent, int type);

//    abstract View onCreateView(int type);
}
