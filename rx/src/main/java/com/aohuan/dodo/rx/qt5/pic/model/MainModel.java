package com.aohuan.dodo.rx.qt5.pic.model;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.aohuan.dodo.rx.qt5.pic.cont.MainContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by dodo_lihao on 2016/12/9.
 * qq: 2390183798
 *      代码来自简书， 英勇青铜5 的文章 http://www.jianshu.com/p/4933445c71ed
 */
public class MainModel implements MainContract.MainBiz {
    @Override
    public void loadPic(final Activity activity, final onLoadPicListener onLoadPicListener) {
        Observable
                .just("image/jpeg,image/png")//图片的格式
                .filter(new Func1<String, Boolean>() {//在查找前 先判断存储卡是否可以用
                    @Override
                    public Boolean call(String str) {
                        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                            return true;
                        } else {
                            onLoadPicListener.onFailed("存储卡不可以用");
                            return false;
                        }
                    }
                })
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {//显示SwipeRefreshLayout的圆圈
                        onLoadPicListener.onLoadBefore();
                    }
                })
//                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<String, List<String>>() {
                    @Override
                    public List<String> call(String type) {//拿到图片路径的集合
                        return getPngAndJpgList(activity, type);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                
                .doOnCompleted(new Action0() {
                    @Override
                    public void call() {//关闭SwipeRefreshLayout的圆圈
                        onLoadPicListener.onLoadAfter();
                    }
                })
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> picPathList) {//将拿到的路径集合进行回调
                        onLoadPicListener.onResult(picPathList);
                    }
                });
    }

    private List<String> getPngAndJpgList(Activity activity, String type) {
        List<String> list = new ArrayList<>();
        Uri imgUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = activity.getContentResolver();

        //查找类型
        String[] types = type.split(",");
        String selection = MediaStore.Images.Media.MIME_TYPE + "=? or "
                + MediaStore.Images.Media.MIME_TYPE + "=?";
        //得到Cursor
        Cursor cursor = contentResolver.query(imgUri, null, selection, types, MediaStore.Images.Media.DATE_MODIFIED);
        if (null != cursor) {
            while (cursor.moveToNext()) {
                // 拿到每个图片的路径
                String picPath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                list.add(picPath);
            }
            cursor.close();
        }
        //将集合倒序
        Collections.reverse(list);
        return list;
    }
}