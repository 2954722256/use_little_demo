package com.aohuan.dodo.anim.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.aohuan.dodo.anim.R;
import com.aohuan.dodo.anim.utils.mrzk.controller.animationUtils.TransitionController;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class T0MidActivity extends AppCompatActivity {

    @InjectView(R.id.lv)
    ListView lv;

    ArrayList<String> strArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t0_mid);
        ButterKnife.inject(this);
        addData();
        lv.setAdapter(new CommonAdapter<String>(this, R.layout.item_t0_list_cardview, strArray) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
//                viewHolder.setImageResource(R.id.customImage, R.drawable.euler);
                viewHolder.getView(R.id.cardv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TransitionController.getInstance()
                                .startActivity(T0MidActivity.this,
                                        new Intent(T0MidActivity.this, T1StraActivity.class),
                                        view, R.id.iv_second);
                    }
                });
            }
        });
    }

    private void addData() {
        for (int i = 0; i < 10; i++) {
            strArray.add("dodo dodo " + i);
        }
    }


}
