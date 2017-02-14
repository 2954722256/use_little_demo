package com.aohuan.dodo.request.nohttp;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.aohuan.dodo.common.utils.base.ABaseAutoActivity;
import com.aohuan.dodo.common.utils.base.AhView;
import com.aohuan.dodo.request.R;
import com.aohuan.dodo.request.nohttp.utils.FastJsonRequest;
import com.aohuan.dodo.request.nohttp.utils.HttpListener;
import com.aohuan.dodo.request.nohttp.utils.JavaBeanRequest;
import com.aohuan.dodo.request.utils.Contants;
import com.aohuan.dodo.request.utils.bean.Day13Bean;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.internal.http2.Http2Connection;

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
                request1();
                break;
            case R.id.m_tv_show:
                break;
        }
    }

    private void request1() {
        Request<Day13Bean> request = new JavaBeanRequest<>(Contants.URL_BLIBLI_DAY_113, Day13Bean.class);
//        request(0, request, new HttpListener<Day13Bean>(){
//
//            @Override
//            public void onSucceed(int what, Response<Day13Bean> response) {
//
//            }
//
//            @Override
//            public void onFailed(int what, Response<Day13Bean> response) {
//
//            }
//        }, false, true);
    }


}
