package com.aohuan.dodo.coordinator;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.aohuan.dodo.coordinator.do0.Main0Activity;
import com.aohuan.dodo.coordinator.do1.Main1Activity;
import com.aohuan.dodo.coordinator.do2.Main2Activity;
import com.aohuan.dodo.coordinator.do3.Main3Activity;
import com.aohuan.dodo.coordinator.do4.Main4Activity;
import com.aohuan.dodo.coordinator.do5.Main5Activity;
import com.aohuan.dodo.coordinator.don0.MainN0Activity;
import com.aohuan.dodo.coordinator.utils.Utils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    List<String> mStringArrayList;
    private CommonAdapter<String> commonAdapter = null;     //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list1);
        mStringArrayList = Arrays.asList(getResources().getStringArray(R.array.typelist));
        commonAdapter = new CommonAdapter<String>(MainActivity.this, R.layout.item_string, mStringArrayList){
            @Override
            protected void convert(ViewHolder viewHolder, String item, int i) {
                viewHolder.setText(R.id.tv1, item);
            }
        };
        mListView.setAdapter(commonAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                doPosition(i);
            }
        });
    }

    private void doPosition(int i) {
        Log.e("do", "aaa  " + i);
        switch (i){
            case 0:
                toActivity(Main0Activity.class);
                break;
            case 1:
                toActivity(Main1Activity.class);
                break;
            case 2:
                toActivity(Main2Activity.class);
                break;
            case 3:
                toActivity(Main3Activity.class);
                break;
            case 4:
                toActivity(Main4Activity.class);
                break;
            case 5:
                toActivity(Main5Activity.class);
                break;
            case 6:
                toActivity(Main0Activity.class);
                break;
//            case 7:
//                toActivity(Main0Activity.class);
//                break;
//            case 8:
//                toActivity(Main0Activity.class);
//                break;
//            case 9:
//                toActivity(Main0Activity);
//                break;
//            case  10:
//                toActivity(Main0Activity.class);
//                break;
//            case  11:
//                toActivity(Main0Activity.class);
//                break;
//            case  12:
//                toActivity(Main0Activity.class);
//                break;
//            case  13:
////                toActivity(Main0Activity.class);
//                break;
            default:
                Toast.makeText(this,"default", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    Intent mIntent;
    private void toActivity(Class cls){
        mIntent = new Intent(this, cls);
        startActivity(mIntent);
    }

    private void getBarHeight(){
        Utils.setContentTop(getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop());
    }

}
