package com.aohuan.demo.eventbus3test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aohuan.demo.eventbus3test.bean.FutureBean;
import com.aohuan.demo.eventbus3test.bean.MessageBean2;
import com.aohuan.demo.eventbus3test.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tv)
    TextView tv;
    @InjectView(R.id.go)
    Button go;
    @InjectView(R.id.goFuture)
    Button goFuture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        Object o;
//        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }


    @Subscribe
    public void handEvent(MessageEvent messageEvent) {
        tv.setText(messageEvent.getMessage());
    }

    @Subscribe
    public void handEvent(MessageBean2 messageEvent) {
        tv.setText(messageEvent.toString());
    }


    @OnClick({R.id.tv, R.id.go, R.id.goFuture})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                startActivity(new Intent(this, Detail3Activity.class));
                break;
            case R.id.go:
//                Toast.makeText(MainActivity.this, "gogo", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Detail2Activity.class));
                break;
            case R.id.goFuture:
                doGoFuture();
                break;
        }
    }

    private void doGoFuture() {
//        Toast.makeText(MainActivity.this, "gogo2", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().postSticky(new FutureBean("noName", "100"));
        startActivity(new Intent(this, Future1Activity.class));
    }
}
