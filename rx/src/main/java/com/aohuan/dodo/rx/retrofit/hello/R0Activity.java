package com.aohuan.dodo.rx.retrofit.hello;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.aohuan.dodo.rx.R;
import com.aohuan.dodo.rx.qt5.pic.adapter.RvAdapter;
import com.aohuan.dodo.rx.qt5.pic.utils.CommonBaseAdapter;
import com.aohuan.dodo.rx.qt5.pic.utils.RVItemDecoration;
import com.aohuan.dodo.rx.retrofit.hello.bean.TaoBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.EmptyWrapper;

import java.util.ArrayList;
import java.util.Random;

public class R0Activity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
//    private RvAdapter adapter;
    private TaoBean tbean;
    ArrayList<String> strArray = new ArrayList<>();
    CommonAdapter<String> commonAdapter;
    EmptyWrapper mEmptyWrapper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r0);
        init();
    }

    private void init() {
        setData();
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl_main_activity);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);
//        swipeRefreshLayout.setEnabled(false);//禁止下拉刷新
        swipeRefreshLayout.setEnabled(true);//
        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_main_activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        commonAdapter = new CommonAdapter<String>(this, R.layout.item_layout_r0, strArray) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.tv1, item);
            }
        };
        mEmptyWrapper = new EmptyWrapper(commonAdapter);
        mEmptyWrapper.setEmptyView(R.layout.base_empty);
        recyclerView.setAdapter(mEmptyWrapper);


    }

    @Override
    public void onRefresh() {
        Random random = new Random(500);
        int num = random.nextInt(10);

        if(num>3){
            Toast.makeText(this, "add num: " + num ,Toast.LENGTH_SHORT).show();
            doAddData();
        }else{
            Toast.makeText(this, "emtpy: " + num , Toast.LENGTH_SHORT).show();
        }
    }

    private void doEmptyView()
    {
//        recyclerView.
        swipeRefreshLayout.setRefreshing(false);
    }

    int num = 0;
    public void doAddData(){
//        swipeRefreshLayout.setRefreshing(true);
        strArray.add(1,"dodoR"+num++);
//        recyclerView.notify();
        commonAdapter.notifyItemInserted(1);
        swipeRefreshLayout.setRefreshing(false);
    }


    private void setData() {
        for(int i=0; i<50; i++){
            strArray.add("dodo " + i);
        }
    }
}
