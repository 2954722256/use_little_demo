package com.aohuan.dodo.viewdemo.tab.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/5 0005.
 */
public class CommonFragmentViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragList;
    public CommonFragmentViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mFragList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragList.get(position);
    }

    @Override
    public int getCount() {
        return mFragList.size();
    }
}
