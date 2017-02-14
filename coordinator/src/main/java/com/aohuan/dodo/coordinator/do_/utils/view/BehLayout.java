package com.aohuan.dodo.coordinator.do_.utils.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

import com.aohuan.dodo.coordinator.do_.utils.behavior.DodoBehavior0be;
import com.aohuan.dodo.coordinator.do_.utils.behavior.DodoBehavior0s;

/**
 * Created by dodo_lihao on 2017/2/9.
 * qq: 2390183798
 */
@CoordinatorLayout.DefaultBehavior(DodoBehavior0be.class)
public class BehLayout extends FrameLayout {
    public BehLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BehLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
