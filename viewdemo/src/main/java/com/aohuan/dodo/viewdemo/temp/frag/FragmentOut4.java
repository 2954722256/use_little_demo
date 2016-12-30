package com.aohuan.dodo.viewdemo.temp.frag;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aohuan.dodo.viewdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Temp03 use
 */
public class FragmentOut4 extends Fragment {


    @InjectView(R.id.tab_main)
    TabLayout tabMain;
    @InjectView(R.id.m_viewpager)
    ViewPager mViewpager;

    private List<Fragment> fagList = new ArrayList<>();

    String titlePreName = "Out4 ";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabstrip_out_4, container, false);
        ButterKnife.inject(this, view);
        init();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void init() {
        initFrag();
        setTab();
    }

    private void initFrag() {
        for (int i = 0; i < 4; i++) {
            ContentFragment homePageFrg = new ContentFragment();
//            Bundle b = new Bundle();
//            b.putString("sort", titlePreName + i + "");
//            homePageFrg.setArguments(b);
            fagList.add(homePageFrg);
        }
    }

    MyAdapter mMyAdapter;
    private void setTab() {
        mMyAdapter = new MyAdapter(getChildFragmentManager());
        mViewpager.setOffscreenPageLimit(fagList.size());
        mViewpager.setAdapter(mMyAdapter);
        tabMain.setupWithViewPager(mViewpager);
        for(int i=0; i<mViewpager.getAdapter().getCount(); i++){
            tabMain.getTabAt(i).setText(mViewpager.getAdapter().getPageTitle(i));
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fagList.get(position);
        }

        @Override
        public int getCount() {
            return fagList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titlePreName + position;
        }
    }



}
