package com.aohuan.dodo.viewdemo.temp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.temp.frag.SocetyClassifyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TabStrip01Activity extends AppCompatActivity {


    @InjectView(R.id.m_tabs)
    com.astuetz.PagerSlidingTabStrip mTabs;
    @InjectView(R.id.m_viewpager)
    ViewPager mViewpager;

    private List<Fragment> fagList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabstrip01);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        initFrag();
        setPageTitle();
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

    /*设置Title样式*/
    private void setPageTitle() {
        mViewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTabs.setViewPager(mViewpager);
        mViewpager.setOffscreenPageLimit(fagList.size());//保存viewpage数据不被回收
        mTabs.setIndicatorHeight(5);//设置下划线宽度
        mTabs.setUnderlineHeight(0);//设置底部边框宽度
        mTabs.setDividerColor(getResources().getColor(R.color.transparent)); //中间竖线颜色
        mTabs.setIndicatorColor(0xff168cf6);// 下划线颜色
//        mTabs.setSelectedTextColor(0xff333333);//文字选中颜色
        mTabs.setIndicatorColor(0xff333333);
        mTabs.setTextColor(0xff333333);//没有选中时文字颜色
        mTabs.setTextSize(getResources().getDimensionPixelSize(R.dimen.px36));//字体大小
        mTabs.setShouldExpand(true);
        mTabs.setTabBackground(R.drawable.background_tab);
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
