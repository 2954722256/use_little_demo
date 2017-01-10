package com.aohuan.dodo.viewdemo.tab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.aohuan.dodo.viewdemo.R;
import com.aohuan.dodo.viewdemo.tab.frag.FragmentOut2;
import com.aohuan.dodo.viewdemo.tab.frag.FragmentOut22;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TabStrip03Activity extends AppCompatActivity {


    @InjectView(R.id.rb_home)
    RadioButton rbHome;
    @InjectView(R.id.rb_news)
    RadioButton rbNews;
    @InjectView(R.id.rg_group)
    RadioGroup rgGroup;
    @InjectView(R.id.vp_main)
    ViewPager mViewpager;

    private List<Fragment> fagList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabstrip03);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        initFrag();
        setPageTitle();
    }



    private void initFrag() {
        FragmentOut2 fo21 = new FragmentOut2();
        FragmentOut22 fo22 = new FragmentOut22();
        fagList.add(fo21);
        fagList.add(fo22);
    }

    private void setPageTitle() {
        btnClickBg(true);
        mViewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mViewpager.setOffscreenPageLimit(fagList.size());//保存viewpage数据不被回收
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_home) {
                    mViewpager.setCurrentItem(0, false);//去掉切换页面的动画
                    btnClickBg(true);
                } else if (i == R.id.rb_news) {
                    mViewpager.setCurrentItem(1, false);
                    btnClickBg(false);
                }
            }
        });
    }

    void btnClickBg(boolean isFirst){
        rbHome.setBackgroundColor(isFirst ? Color.GRAY : Color.WHITE);
        rbNews.setBackgroundColor(isFirst ? Color.WHITE : Color.GRAY);
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
