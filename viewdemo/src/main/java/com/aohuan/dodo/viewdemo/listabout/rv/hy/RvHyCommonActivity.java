package com.aohuan.dodo.viewdemo.listabout.rv.hy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.ImageView;

import com.aohuan.dodo.viewdemo.R;
import com.bumptech.glide.Glide;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

public class RvHyCommonActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    ArrayList<String> strArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_hy_common);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        setData();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new CommonAdapter<String>(this, R.layout.item_rv_o1_1, strArray) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.teach_item_name, item);
            }
        });
    }


    private void setData() {
        for(int i=0; i<50; i++){
            strArray.add("dodo " + i);
        }
    }
}
