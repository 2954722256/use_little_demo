package com.aohuan.dodo.viewdemo.temp.frag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aohuan.dodo.viewdemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SocetyClassifyFragment extends Fragment {
    @InjectView(R.id.m_test)
    TextView mTest;
    private String mSort = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabstrip_socety_classify, container, false);
        ButterKnife.inject(this, view);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        initView();
    }

    private void initView() {
        mSort = getArguments().getString("sort");
        Log.e("haha", "mSort:::" + mSort);
        mTest.setText(mSort);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
