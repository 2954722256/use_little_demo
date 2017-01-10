package com.aohuan.dodo.viewdemo.tab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.tab.frag.SocetyClassifyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TabStrip02Activity extends AppCompatActivity {

    @InjectView(R.id.tab_main)
    TabLayout tabMain;
    @InjectView(R.id.m_viewpager)
    ViewPager mViewpager;
    @InjectView(R.id.m_parent_view)
    LinearLayout mParentView;

    private List<Fragment> fagList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabstrip02);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        initFrag();
        initPager();
    }

    private void initFrag() {
        for (int i = 0 ; i< 4 ;i++){
            SocetyClassifyFragment homePageFrg = new SocetyClassifyFragment();
            Bundle b = new Bundle();
            b.putString("sort", i + "");
            homePageFrg.setArguments(b);
            fagList.add(homePageFrg);
        }
    }

    private void initPager() {
        mViewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabMain.setupWithViewPager(mViewpager);

        for(int i=0; i<mViewpager.getAdapter().getCount(); i++){
            tabMain.getTabAt(i).setText(mViewpager.getAdapter().getPageTitle(i));
        }
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
            return "dodo  " + position;
        }
    }

}
