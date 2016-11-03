package com.aohuan.dodo.coordinator.do4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.aohuan.dodo.coordinator.R;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.Arrays;
import java.util.List;

public class Main4Activity extends AppCompatActivity {

    ListView mListView;
    ListView mListView1;
    //    RecyclerView mListView;
    List<String> mStringArrayList;
    private CommonAdapter<String> commonAdapter = null;     //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

//        mStringArrayList = Arrays.asList(getResources().getStringArray(R.array.temp));
//        mListView = (ListView) findViewById(R.id.list0);
//        mListView1 = (ListView) findViewById(R.id.list1);
//
//
//        mListView.setAdapter(new CommonAdapter<String>(Main4Activity.this, R.layout.item_string, mStringArrayList){
//            @Override
//            protected void convert(ViewHolder viewHolder, String item, int i) {
//                viewHolder.setText(R.id.tv1, item);
//            }
//        });
//
//        mListView1.setAdapter(new CommonAdapter<String>(Main4Activity.this, R.layout.item_string, mStringArrayList){
//            @Override
//            protected void convert(ViewHolder viewHolder, String item, int i) {
//                viewHolder.setText(R.id.tv1, item);
//            }
//        });
    }

}
