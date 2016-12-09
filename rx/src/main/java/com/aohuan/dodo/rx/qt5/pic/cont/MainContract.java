package com.aohuan.dodo.rx.qt5.pic.cont;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by dodo_lihao on 2016/12/9.
 * qq: 2390183798
 *      代码来自简书， 英勇青铜5 的文章 http://www.jianshu.com/p/4933445c71ed
 */
public class MainContract {
    public interface MainBiz {
        void loadPic(Activity activity, onLoadPicListener onLoadPicListener);
        interface onLoadPicListener {
            void onLoadBefore();
            void onLoadAfter();
            void onResult(List<String> picPathList);
            void onFailed(String info);
        }
    }

    public interface View {
        void showProgress();
        void closeProgress();
        void showInfo(String info);
        void bindPresenter(Presenter presenter);
        void initView();
    }

    public interface Presenter {
        void getRecyclerView(RecyclerView recyclerView);
        void load(Activity activity);
        void recycle();
    }
}
