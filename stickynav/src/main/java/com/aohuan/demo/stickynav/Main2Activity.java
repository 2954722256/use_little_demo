package com.aohuan.demo.stickynav;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ListView;

import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    StickNavDodoView mStickyNavLayoutView;
    AbsListView mListView;
    ArrayList<String> strList = new ArrayList<>();
    CommonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosth2);
        addData(20);
        dosth();
    }

    private void addData(int num) {
        for(int i=0; i<num; i++){
            strList.add("Fake data " + (i+1));
        }
    }

    private void dosth() {
        mStickyNavLayoutView = (StickNavDodoView) findViewById(R.id.stickyNavLayout);
        mListView = (AbsListView) findViewById(R.id.id_bottomview);
//        mListView = mStickyNavLayoutView.getListView();
        mListView.setAdapter(adapter = new CommonAdapter<String>(this, R.layout.item_dosth ,strList) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.tv01, item);
            }
        });
        changeItems(50);
    }
    private void changeItems(int num) {
        mStickyNavLayoutView.setContentHeight(num);
        strList.clear();
        addData(num);
        adapter.notifyDataSetChanged();
    }

}
