package com.aohuan.dodo.quickside.saiwu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.aohuan.dodo.quickside.R;
import com.bigkoo.quicksidebar.QuickSideBarTipsView;
import com.bigkoo.quicksidebar.QuickSideBarView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class S1Activity extends AppCompatActivity {


    @InjectView(R.id.recyclerView)
    RecyclerView recyclerView;
    @InjectView(R.id.quickSideBarTipsView)
    QuickSideBarTipsView quickSideBarTipsView;
    @InjectView(R.id.quickSideBarView)
    QuickSideBarView quickSideBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s1);
        ButterKnife.inject(this);

        doSth();
    }

    private void doSth() {

    }


}
