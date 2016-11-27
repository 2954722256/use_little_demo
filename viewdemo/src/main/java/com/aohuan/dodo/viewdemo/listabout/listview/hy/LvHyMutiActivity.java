package com.aohuan.dodo.viewdemo.listabout.listview.hy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.listabout.listview.hy.adapter.ChatAdapter;
import com.aohuan.dodo.viewdemo.listabout.listview.hy.bean.ChatMessage;
import com.zhy.adapter.abslistview.CommonAdapter;

public class LvHyMutiActivity extends AppCompatActivity {

    private ListView mListView;
    private CommonAdapter mAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_hy_muti);
        mListView = (ListView) findViewById(R.id.id_listview_list);
        mListView.setDivider(null);
        mListView.setAdapter(new ChatAdapter(this, ChatMessage.MOCK_DATAS));
//        new CommonAdapter<>()
    }

}
