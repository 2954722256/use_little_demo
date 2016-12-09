package com.aohuan.dodo.rx.qt5.pic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

import com.aohuan.dodo.rx.R;

import java.io.File;

import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class Q1ShowPicActivity extends AppCompatActivity {
    private ImageView iv;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//去掉ActionBar
        setContentView(R.layout.activity_q1_show_pic);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        //ImageView
        iv = (ImageView) findViewById(R.id.iv_show_activity);
        //设置ToolBar
        mToolBar = (Toolbar) findViewById(R.id.toolbar_show_activity);
        setSupportActionBar(mToolBar);
        ActionBar bar = getSupportActionBar();
        if (null != bar) {
            bar.setDisplayHomeAsUpEnabled(true);
            getPicPath();//路径
        }
    }

    /**
     * 拿到传过来的图片路径
     */
    private void getPicPath() {
        Intent i = getIntent();
        if (null != i) {
            Bundle b = i.getExtras();
            String picPath = (String) b.get("picPath");
            if (null != picPath) {
                File file = new File(picPath);
                showPicFileByLuban(file);
            }
        }
    }

    /**
     * 展示图片
     */
    private void showPicFileByLuban(@NonNull File file) {
        Luban.get(this)
                .load(file)//目标图片
                .putGear(Luban.THIRD_GEAR)//压缩等级
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {//开始压缩
                    }

                    @Override
                    public void onSuccess(File file) {//压缩成功，拿到压缩的图片，在UI线程
                        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        mToolBar.setSubtitle(bitmap.getWidth() + "*" + bitmap.getHeight() + "-->" + bitmap.getByteCount());
                        iv.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onError(Throwable e) {//压缩失败
                    }
                })
                .launch();//开启压缩
    }

    /**
     * ToolBar返回箭头监听
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
