package com.aohuan.dodo.viewdemo.listabout.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dodo_lihao on 2016/12/19.
 * qq: 2390183798
 */
public class BaseHolder extends PreBaseHolder{

    public BaseHolder(View itemView, int type){

        super(itemView);

    }
    
//    public void init(int type){
//        View view = onCreateView(1);
//
//    }
//
//    abstract View onCreateView(int type);

    @Override
    BaseHolder onCreateHolder(Context context, ViewGroup parent, int type) {
        return null;
    }
}
