package com.aohuan.dodo.coordinator.do3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.aohuan.dodo.coordinator.R;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.Arrays;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    ListView mListView1;
    //    RecyclerView mListView;
    List<String> mStringArrayList;
    private CommonAdapter<String> commonAdapter = null;     //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        mStringArrayList = Arrays.asList(getResources().getStringArray(R.array.temp));
//
//        mListView1 = (ListView) findViewById(R.id.list1);
//
//        mListView1.setAdapter(new CommonAdapter<String>(Main3Activity.this, R.layout.item_string, mStringArrayList){
//            @Override
//            protected void convert(ViewHolder viewHolder, String item, int i) {
//                viewHolder.setText(R.id.tv1, item);
//            }
//        });
    }

}
