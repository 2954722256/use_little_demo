package com.aohuan.dodo.viewdemo.listabout.rv.other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.listabout.rv.other.adapter.DynamicHeightRecyclerAdapter;
import com.aohuan.dodo.viewdemo.listabout.rv.other.bean.DynamicHeightBean;

import java.util.ArrayList;
import java.util.List;

public class RvO2Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    Toolbar toolbar;

    DynamicHeightRecyclerAdapter adapter;

    private List<DynamicHeightBean> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_o2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);


        //设置布局管理器
//        1、第一种LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayout.HORIZONTAL);

        //2、第二种 GridLayoutManager
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
//        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position == 0) {
//                    return 2;
//                } else {
//                    return 1;
//                }
//            }
//        });

        //3、第三种
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

//        layoutManager.set

        mRecyclerView.setLayoutManager(layoutManager);
        //绑定适配器
        adapter = new DynamicHeightRecyclerAdapter(this, getData());
        mRecyclerView.setAdapter(adapter);
    }

    private List<DynamicHeightBean> getData() {
        for (int i = 0; i < 30; i++) {
            DynamicHeightBean model = new DynamicHeightBean();
            model.setName("dodo---" + i);
            model.setHeight(((int) (Math.random() * 200 + 250)));
            mDatas.add(model);
        }
        return mDatas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_o2, menu);
        return true;
    }

    private void addDataAndNotify(int i){
        DynamicHeightBean model = new DynamicHeightBean();
        model.setName("do InAdd---");
        model.setHeight(((int) (Math.random() * 200 + 250)));
        mDatas.add(i, model);
        adapter.notifyItemInserted(i);
    }

    private void deleteDataAndNotify(int i){
        mDatas.remove(i);
        adapter.notifyItemRemoved(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";

        switch (item.getItemId()) {
            case R.id.o21:
                addDataAndNotify(1);
                break;
            case R.id.o22:
                deleteDataAndNotify(1);
                break;
            case R.id.o23:
                LinearLayoutManager llmH = new LinearLayoutManager(this);
                llmH.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(llmH);
                break;
            case R.id.o24:
                LinearLayoutManager llmV = new LinearLayoutManager(this);
                llmV.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(llmV);
                break;
            case R.id.o25:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
                break;
            case R.id.o26:
                GridLayoutManager glm2 = new GridLayoutManager(this, 2);

                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.o27:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
        }

        if(!msg.equals("")) {
            Toast.makeText(getApplication(), msg, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
