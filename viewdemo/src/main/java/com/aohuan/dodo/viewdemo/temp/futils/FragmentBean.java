package com.aohuan.dodo.viewdemo.temp.futils;

import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class FragmentBean {
    private Fragment fragment;
    private TextView textView;
    private ImageView imageView;
    private int image;
    private int imageClick;

    public FragmentBean(Fragment fragment, TextView textView, ImageView imageView, int image, int imageClick) {
        this.fragment = fragment;
        this.image = image;
        this.imageClick = imageClick;
        this.imageView = imageView;
        this.textView = textView;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImageClick() {
        return imageClick;
    }

    public void setImageClick(int imageClick) {
        this.imageClick = imageClick;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
