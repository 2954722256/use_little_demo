package com.aohuan.dodo.viewdemo.listabout.rv.bili;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Toast;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.listabout.rv.bili.bean.RecommendInfo;
import com.aohuan.dodo.viewdemo.listabout.rv.bili.utils.FakeData;
import com.aohuan.dodo.viewdemo.listabout.utils.ConstantUtil;

import java.util.List;

/**
 * 是学习对应的Rv的排布以及处理
 *
 *      具体可见真正作者的页面： http://www.jianshu.com/p/f69a55b94c05
 *          https://github.com/HotBitmapGG
 *
 *
 */
public class RvB1Activity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecommendInfo bean ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_b1);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        initRecyclerView();
        addData();
    }

    private void addData() {
        bean = FakeData.getRecommendData();
        if(bean == null){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }else{
            bean = new RecommendInfo();
        }
        List<RecommendInfo.ResultBean> results = bean.getResult();

    }

    private void initRecyclerView(){

    }

}
