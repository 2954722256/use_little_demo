package com.aohuan.dodo.viewdemo.uni;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.aohuan.dodo.common.utils.base.ABaseAutoActivity;
import com.aohuan.dodo.common.utils.base.AhView;
import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.tab.adapter.CommonFragmentViewPagerAdapter;
import com.aohuan.dodo.viewdemo.tab.frag.ContentFragment;
import com.aohuan.dodo.viewdemo.tab.frag.ContentWithHorizListFragment;
import com.aohuan.dodo.viewdemo.tab.frag.FragmentOut4;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

@AhView(R.layout.activity_uni01)
public class Uni01Activity extends ABaseAutoActivity {

    @InjectView(R.id.m_viewpager)
    ViewPager mViewpager;

    @InjectView(R.id.rb_home)
    RadioButton rbHome;
    @InjectView(R.id.rb_news)
    RadioButton rbNews;
    @InjectView(R.id.rb_news2)
    RadioButton rbNews2;
    @InjectView(R.id.rg_group)
    RadioGroup rgGroup;

    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    void btnClick(int index) {
        if (index > 2 || index < 0) {
            return;
        }
        mViewpager.setCurrentItem(index, false);//去掉切换页面的动画
        btnClickBg(index);
    }

    void btnClickBg(int index) {
        if (index > 2 || index < 0) {
            return;
        }
        rbHome.setBackgroundColor(index == 0 ? Color.GRAY : Color.WHITE);
        rbNews.setBackgroundColor(index == 1 ? Color.GRAY : Color.WHITE);
        rbNews2.setBackgroundColor(index == 2 ? Color.GRAY : Color.WHITE);
    }

    private void init() {
        initFrag();
        setPagerTitle();
    }

    private void setPagerTitle() {
        btnClickBg(0);
        mViewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mViewpager.setOffscreenPageLimit(mFragmentList.size());//保存viewpage数据不被回收
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_home:
                        btnClick(0);
                        break;
                    case R.id.rb_news:
                        btnClick(1);
                        break;
                    case R.id.rb_news2:
                        btnClick(2);
                        break;
                }
            }
        });
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

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "dodo  " + position;
        }
    }

}
