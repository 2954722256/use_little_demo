package com.aohuan.dodo.coordinator.don0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

import com.aohuan.dodo.coordinator.R;
//import com.zhy.adapter.recyclerview.CommonAdapter;
//import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.Arrays;
import java.util.List;

public class MainN0Activity extends AppCompatActivity {

    ListView mListView;
//    RecyclerView mListView;
    List<String> mStringArrayList;
    private CommonAdapter<String> commonAdapter = null;     //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_n0);

        mStringArrayList = Arrays.asList(getResources().getStringArray(R.array.temp));

//        mListView = (RecyclerView) findViewById(R.id.list0);


        Toast.makeText(this, "" + mStringArrayList.size(), Toast.LENGTH_SHORT).show();

        mListView = (ListView) findViewById(R.id.list0);

        commonAdapter = new CommonAdapter<String>(MainN0Activity.this, R.layout.item_string, mStringArrayList){
            @Override
            protected void convert(ViewHolder viewHolder, String item, int i) {
                viewHolder.setText(R.id.tv1, item);
            }
        };

        mListView.setAdapter(commonAdapter);
    }

}
