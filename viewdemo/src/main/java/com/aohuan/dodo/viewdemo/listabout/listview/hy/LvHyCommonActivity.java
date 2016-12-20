package com.aohuan.dodo.viewdemo.listabout.listview.hy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.aohuan.dodo.viewdemo.R;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;

public class LvHyCommonActivity extends AppCompatActivity {
    private ListView mListView;
    ArrayList<String> strArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_hy_common);
        mListView = (ListView) findViewById(R.id.id_listview_list);
        mListView.setDivider(null);
        setData();
        mListView.setAdapter(new CommonAdapter<String>(this, R.layout.item_rv_o1_1,strArray) {
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
