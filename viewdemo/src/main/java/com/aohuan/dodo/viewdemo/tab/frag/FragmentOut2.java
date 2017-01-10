package com.aohuan.dodo.viewdemo.tab.frag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aohuan.dodo.viewdemo.R;
import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Temp03 use
 */
public class FragmentOut2 extends Fragment {

    @InjectView(R.id.m_tabs)
    PagerSlidingTabStrip mTabs;
    @InjectView(R.id.m_viewpager)
    ViewPager mViewpager;
    @InjectView(R.id.m_parent_view)
    LinearLayout mParentView;

    private List<Fragment> fagList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabstrip_out_1, container, false);
        ButterKnife.inject(this, view);
        init();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public ViewPager getViewPager(){
        return mViewpager;
    }


    private void init() {
        initFrag();
        setPageTitle();
    }

    private void initFrag() {
        for (int i = 0 ; i< 4 ;i++){
            SocetyClassifyFragment homePageFrg = new SocetyClassifyFragment();
            Log.e("haha", "homePageFrg:::" + homePageFrg.hashCode());
            Bundle b = new Bundle();
            b.putString("sort", "Out2 " + i + "");
            homePageFrg.setArguments(b);
            fagList.add(homePageFrg);
        }
    }


    /*设置Title样式*/
    private void setPageTitle() {
        mViewpager.setAdapter(new MyAdapter(getChildFragmentManager()));
//        mViewpager.setAdapter(new MyAdapter(getActivity().getSupportLoaderManager().));
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

    public void setmViewpagerEnable(boolean isEnable){
        mViewpager.setEnabled(isEnable);
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
            return "Out2  " + position;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
