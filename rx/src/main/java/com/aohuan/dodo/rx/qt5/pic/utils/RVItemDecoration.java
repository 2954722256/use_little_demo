package com.aohuan.dodo.rx.qt5.pic.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by C.C on 2016/7/13.
 */
public class RVItemDecoration extends RecyclerView.ItemDecoration {
    private int decoration ;

    public RVItemDecoration(int decoration) {
        this.decoration = decoration;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = decoration;
        outRect.right = decoration;
        outRect.top = decoration;
        outRect.bottom = decoration;
    }
}
