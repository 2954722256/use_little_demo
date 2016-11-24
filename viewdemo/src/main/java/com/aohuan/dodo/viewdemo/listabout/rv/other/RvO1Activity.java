package com.aohuan.dodo.viewdemo.listabout.rv.other;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.listabout.listview.hy.bean.ChatMessage;
import com.aohuan.dodo.viewdemo.listabout.rv.other.bean.DynamicHeightBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodo_lihao on 2016/11/24.
 * qq: 2390183798
 */
public class RvO1Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<ChatMessage> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_hy_mutil);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

        //设置布局管理器
        //1、第一种LinearLayoutManager
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //2、第二种 GridLayoutManager
//        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        //3、第三种
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        //绑定适配器
        RecyclerAdapter adapter = new RecyclerAdapter(this, getData());
        mRecyclerView.setAdapter(adapter);
    }

    private List<DynamicHeightBean> getData() {
        List<DynamicHeightBean> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            DynamicHeightBean model = new DynamicHeightBean();
            model.setName("dodododo doooo---" + i);
            model.setHeight(((int) (Math.random() * 200 + 250)));
            data.add(model);
        }
        return data;
    }


}

