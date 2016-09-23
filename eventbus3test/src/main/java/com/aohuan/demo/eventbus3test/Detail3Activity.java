package com.aohuan.demo.eventbus3test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aohuan.demo.eventbus3test.bean.MessageBean2;
import com.aohuan.demo.eventbus3test.send.Sender;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Detail3Activity extends AppCompatActivity {

    @InjectView(R.id.tv)
    TextView tv;
    @InjectView(R.id.back)
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail3);
        ButterKnife.inject(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void doBack() {
//        EventBus.getDefault().post(new MessageEvent("Hello everyone!"));
        Sender.doSend1(new MessageBean2("dodo", "23"));
        finish();
    }

    @OnClick({R.id.tv, R.id.back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                break;
            case R.id.back:
                doBack();
                break;
        }
    }
}
