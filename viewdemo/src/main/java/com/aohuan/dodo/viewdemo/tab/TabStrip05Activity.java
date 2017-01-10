package com.aohuan.dodo.viewdemo.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.aohuan.dodo.common.utils.base.ABaseAutoActivity;
import com.aohuan.dodo.common.utils.base.AhView;
import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.tab.adapter.CommonFragmentViewPagerAdapter;
import com.aohuan.dodo.viewdemo.tab.frag.ContentFragment;
import com.aohuan.dodo.viewdemo.tab.frag.ContentWithHorizListFragment;
import com.aohuan.dodo.viewdemo.tab.frag.FragmentOut4;
import com.aohuan.dodo.viewdemo.tab.pagerhelper.NoScrollViewPager2;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;


@AhView(R.layout.activity_tab_strip05)
public class TabStrip05Activity extends ABaseAutoActivity {

    @InjectView(R.id.rb_home)
    RadioButton rbHome;
    @InjectView(R.id.rb_news)
    RadioButton rbNews;
    @InjectView(R.id.rb_news2)
    RadioButton rbNews2;
    @InjectView(R.id.rg_group)
    RadioGroup rgGroup;
    @InjectView(R.id.m_viewpager)
    NoScrollViewPager2 mViewpager;

    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        initFrag();
    }

    private void initFrag() {
        ContentWithHorizListFragment hFrag1 = new ContentWithHorizListFragment();
        ContentFragment contentFragment2 = new ContentFragment();
        FragmentOut4 pagerFrag = new FragmentOut4();
        mFragmentList.add(hFrag1);
        mFragmentList.add(contentFragment2);
        mFragmentList.add(pagerFrag);
        mViewpager.setAdapter(new CommonFragmentViewPagerAdapter(getSupportFragmentManager(), mFragmentList));
        mViewpager.setOffscreenPageLimit(3);
    }


}
