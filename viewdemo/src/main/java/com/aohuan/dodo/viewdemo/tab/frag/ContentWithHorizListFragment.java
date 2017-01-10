package com.aohuan.dodo.viewdemo.tab.frag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.tab.view.HorizontalListView;
import com.zhy.adapter.abslistview.CommonAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ContentWithHorizListFragment extends Fragment {


    @InjectView(R.id.id_hor_list)
    HorizontalListView idHorList;

    ArrayList<String> strArray = new ArrayList<>();

    CommonAdapter mHorizCommonAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabstrip_content_with_horiz_list, container, false);
        ButterKnife.inject(this, view);
        init();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void init() {
        setData();
        setHori();
    }

    private void setHori() {
        idHorList.setAdapter(mHorizCommonAdapter = new CommonAdapter<String>(getContext(), R.layout.item_tab_strip05_horiz, strArray) {
            @Override
            protected void convert(com.zhy.adapter.abslistview.ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.teach_item_name, item);
            }
        });
    }


    int anInt = 10;
    private void setData() {
        strArray.clear();
        for (int i = 0; i < anInt; i++) {
            strArray.add("dodo " + i);
        }
//        if(anInt < 10){
//            anInt += 2;
//        }else{
//            anInt = 3;
//        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
