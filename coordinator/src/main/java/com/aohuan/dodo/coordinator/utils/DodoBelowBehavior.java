package com.aohuan.dodo.coordinator.utils;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.aohuan.dodo.coordinator.view.DodoMoveView;

/**
 * Created by dodo on 2016/11/1.
 * qq: 2390183798
 *
 *
 * 在Main View 下方
 *      原理也简单， 只要是 Main View 为 DodoMoveView，  就设置 一起动的View的Y值为 自己的Y值 + MainView的Height
 */
public class DodoBelowBehavior extends CoordinatorLayout.Behavior<View> {

    public DodoBelowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setY(dependency.getY()+dependency.getHeight());
        return true;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof DodoMoveView;
    }

}
