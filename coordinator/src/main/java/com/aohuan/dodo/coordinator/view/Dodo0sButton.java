package com.aohuan.dodo.coordinator.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.DefaultBehavior;
import android.util.AttributeSet;
import android.widget.Button;

import com.aohuan.dodo.coordinator.utils.DodoBehavior0s2;

/**
 * Created by dodo on 2016/11/1.
 * qq: 2390183798
 */
@DefaultBehavior(DodoBehavior0s2.class)
public class Dodo0sButton extends Button {
    public Dodo0sButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Dodo0sButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
