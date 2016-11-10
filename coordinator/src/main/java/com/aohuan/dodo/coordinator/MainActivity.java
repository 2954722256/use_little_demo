package com.aohuan.dodo.coordinator;

import android.content.Intent;
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
import com.aohuan.dodo.coordinator.do6.Main6Activity;
import com.aohuan.dodo.coordinator.doa0.MainA0Activity;
import com.aohuan.dodo.coordinator.doa1.MainA1Activity;
import com.aohuan.dodo.coordinator.doa2.MainA2Activity;
import com.aohuan.dodo.coordinator.doa3.MainA3Activity;
import com.aohuan.dodo.coordinator.doa4.MainA4Activity;
import com.aohuan.dodo.coordinator.doa5.MainA5Activity;
import com.aohuan.dodo.coordinator.don0.MainN0Activity;
import com.aohuan.dodo.coordinator.don1.MainN1Activity;
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
                if(i < PART_A){
                    viewHolder.setText(R.id.tv1, "【1】 " + item);
                }else if(i >= PART_A && i < PART_N){
                    viewHolder.setText(R.id.tv1, "【A】 " + item);
                }else if(i >= PART_N){
                    viewHolder.setText(R.id.tv1, "【N】 " + item);
                }
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

    public static final int PART_1 = 0;
    public static final int PART_A = 8;
    public static final int PART_N = 14;

    private void doPosition(int i) {
        Log.e("do", "aaa  " + i);
        switch (i){

            ////===========PART 1
            case PART_1 + 0:
                toActivity(Main0Activity.class);
                break;
            case PART_1 +1:
                toActivity(Main1Activity.class);
                break;
            case PART_1 +2:
                toActivity(Main2Activity.class);
                break;
            case PART_1 +3:
                toActivity(Main3Activity.class);
                break;
            case PART_1 +4:
                toActivity(Main4Activity.class);
                break;
            case PART_1 +5:
                toActivity(Main5Activity.class);
                break;
            case PART_1 +6:
                toActivity(Main6Activity.class);
                break;
//            case PART_1 +7:
//                toActivity(FullscreenActivity.class);
//                break;

            ////===========PART_A

           case PART_A + 0:
                toActivity(MainA0Activity.class);
                break;
            case PART_A + 1:
                toActivity(MainA1Activity.class);
                break;
            case PART_A + 2:
                toActivity(MainA2Activity.class);
                break;
            case PART_A + 3:
                toActivity(MainA3Activity.class);
                break;
            case PART_A + 4:
                toActivity(MainA4Activity.class);
                break;
            case PART_A + 5:
                toActivity(MainA5Activity.class);
                break;

            ////===========PART_N

            case PART_N + 0:
                toActivity(MainN0Activity.class);
                break;
            case PART_N + 1:
                toActivity(MainN1Activity.class);
                break;

//            case PART_2 + 3:
//                toActivity(MainN1Activity.class);
//                break;
//            case PART_2 + 4:
//                toActivity(MainN1Activity.class);
//                break;
//            case PART_2 + 5:
//                toActivity(MainN1Activity.class);
//                break;
//            case PART_2 + 6:
//                toActivity(MainN1Activity.class);
//                break;

//            case  13:
////                toActivity(Main0Activity.class);
//                break;
            default:
                Toast.makeText(this,"没有设置，嘿嘿！！！", Toast.LENGTH_SHORT).show();
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
