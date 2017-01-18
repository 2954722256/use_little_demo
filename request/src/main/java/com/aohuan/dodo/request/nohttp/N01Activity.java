package com.aohuan.dodo.request.nohttp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aohuan.dodo.common.utils.base.ABaseAutoActivity;
import com.aohuan.dodo.common.utils.base.AhView;
import com.aohuan.dodo.request.R;

import butterknife.InjectView;
import butterknife.OnClick;

@AhView(R.layout.nohttp_activity_n01)
public class N01Activity extends ABaseAutoActivity {

    @InjectView(R.id.m_btn_request1)
    Button mBtnRequest1;
    @InjectView(R.id.m_tv_show)
    TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @OnClick({R.id.m_btn_request1, R.id.m_tv_show})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.m_btn_request1:
                break;
            case R.id.m_tv_show:
                break;
        }
    }
}
