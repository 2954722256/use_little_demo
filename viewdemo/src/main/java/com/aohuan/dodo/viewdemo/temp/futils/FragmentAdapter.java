package com.aohuan.dodo.viewdemo.temp.futils;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class FragmentAdapter {
    private List<FragmentBean> mFragmentList = new ArrayList<>();
    FragmentManager mFm = null;
    public FragmentAdapter(List<FragmentBean> fragmentList, int layoutId, FragmentManager fm){
        mFragmentList = fragmentList;
        mFm = fm;
        FragmentTransaction ft = mFm.beginTransaction();
        for (int i=0; i< mFragmentList.size() ; i++){
            ft.add(layoutId, mFragmentList.get(i).getFragment());
        }
        setFragment(0);
        ft.commit();
    }
    public void setFragment(int index) {
        for (int i= 0; i<mFragmentList.size(); i++){
            FragmentTransaction ft = mFm.beginTransaction();
            if(index == i){
                ft.show(mFragmentList.get(i).getFragment());
                setTextViewAndImage(mFragmentList.get(i), true);
            }else {
                ft.hide(mFragmentList.get(i).getFragment());
                setTextViewAndImage(mFragmentList.get(i), false);
            }
            ft.commit();
        }

    }

    void setTextViewAndImage(FragmentBean fragmentBean, boolean isClick){
        setTextView(fragmentBean, isClick);
        setImage(fragmentBean, isClick);
    }

    void setTextView(FragmentBean fragmentBean, boolean isClick){
        if(fragmentBean == null || fragmentBean.getTextView() == null)
            return;

        if(isClick){
            fragmentBean.getTextView().setTextColor(0xfff20f87);
        }else {
            fragmentBean.getTextView().setTextColor(0xff666666);
        }
    }

    void setImage(FragmentBean fragmentBean, boolean isClick){
        if(fragmentBean == null || fragmentBean.getImageView() == null )
            return;

        if(isClick){
            fragmentBean.getImageView().setImageResource(fragmentBean.getImageClick());
        }else {
            fragmentBean.getImageView().setImageResource(fragmentBean.getImage());
        }
    }

}
