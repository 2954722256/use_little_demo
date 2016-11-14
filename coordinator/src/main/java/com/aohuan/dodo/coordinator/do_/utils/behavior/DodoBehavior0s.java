package com.aohuan.dodo.coordinator.do_.utils.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.aohuan.dodo.coordinator.do_.utils.view.DodoMoveView;

/**
 * Created by dodo on 2016/10/31.
 * qq: 2390183798
 *
 * 在y轴 方向跟着移动的 Behavior
 */
public class DodoBehavior0s extends CoordinatorLayout.Behavior<Button> {

    public DodoBehavior0s(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        //如果dependency 是 DodoMoveView类型， 就依赖
        return dependency instanceof DodoMoveView;
    }

    //每次dependency位置发生变化，都会执行onDependentViewChanged方法
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button btn, View dependency) {

        //根据dependency的位置，设置Button的位置
        int x = 0;
        int y = (int) dependency.getY();
        setPosition(btn, x, y);
        return true;
    }

    private void setPosition(View v, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) v.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        v.setLayoutParams(layoutParams);
    }

}
