package com.aohuan.dodo.viewdemo.listabout.rv.sectioned.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;

/**
 * Created by dodo_lihao on 2016/12/16.
 * qq: 2390183798
 */
public class S6LoadingSection extends Section {


    public S6LoadingSection(){
        super(2,1,1);
    }


    @Override
    public int getContentItemsTotal() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return null;
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
